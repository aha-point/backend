package com.ahaPoint.point.domain;

import com.ahaPoint.point.infrastructure.PointHstRepository;
import com.ahaPoint.point.infrastructure.PointRepository;
import com.ahaPoint.point.interfaces.enums.ProcessType;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.infrastructure.SysUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{

    private final PointRepository pointRepository;

    private final PointHstRepository pointHstRepository;
    private final SysUserRepository sysUserRepository;

    private final PointReader pointReader;

    private final Double EVENT_POINT_SIGN_UP = 1000.0;

    @Override
    public Double getCurrentPoint(String phoneNumber) {
        Optional<SysUser> sysUser = sysUserRepository.findByPhoneNumber(phoneNumber);
        if (sysUser.isEmpty()) {
            throw new RuntimeException("해당 사용자가 존재하지 않습니다.");
        }

        return calculateCurrentPoint(sysUser.get().getMember().getMemberId());
    }

    @Override
    public void savePointWhenSignUp(Long memberId) {
        Point toSave = Point.toSave(memberId, EVENT_POINT_SIGN_UP);
        PointHst pointHst = PointHst.toSave(null, memberId, EVENT_POINT_SIGN_UP);
        pointRepository.save(toSave); // 회원가입시 발급받는 포인트에는 storeId 가 없음.
        pointHstRepository.save(pointHst); // hst에 쌓인다.
    }

    @Override
    public Double spendAndEarnPoint(Long storeId, Long memberId, String type, Double spendValue, Double earnValue) {
        if (ProcessType.EARN.equals(type)) {
            // 적립 - save 하고 현재 사용가능한 포인트를 조회한다.
            Point point = Point.toSave(memberId, earnValue);
            PointHst pointHst = PointHst.toSave(storeId, memberId, earnValue);
            pointRepository.save(point);
            pointHstRepository.save(pointHst);
            return calculateCurrentPoint(memberId);
        }

        if (ProcessType.EARN_AND_SPEND.equals(type)) {
            // 사용하고 적립한다.
            // 사용한다 - 일단 해당 포인트 사용이 가능한지 확인 -> 안되면 Exception
            Double currentPoint = calculateCurrentPoint(memberId);
            if (spendValue > currentPoint) {
                throw new RuntimeException("포인트 사용이 불가합니다.");
            }

            // 해당 유저의 포인트를 가지고 온다.
            List<Point> points = pointReader.findAbleToUsePoint(memberId);
            for (Point point : points) {
                Double value = point.getValue();
                if (spendValue >= value) { // 사용하고자 하는 포인트가 더 크거나 같다.
                    // 그러면 해당 point는 상태값을 변환하고 저장한다.
                    pointRepository.updatePointComplete(point, storeId);
                    spendValue -= value;
                } else { // 사용하고자 하는 포인트가 더 작다. -> 그러면 해당 포인트가 쪼개져서 해당 포인트 만큼 complete된다.
                    // 기존 point 는 complete와 unused로 쪼개진다.
                    // 사용한건 update 치고 상태변화 하고 남은 건 새롭게 save한다.
                    pointRepository.updateDividePointComplete(point, spendValue);
                    Point unusedPoint = Point.toMakeUnusedPoint(point, spendValue);

                    // value > spendValue -> spendValue 만큼 complete 분기처리
                    pointRepository.save(unusedPoint);


                }
                // 사용한 포인트만큼 hst에 쌓는다.
                PointHst pointHst = PointHst.toSpend(storeId, memberId, spendValue);
                pointHstRepository.save(pointHst);
            }
            return calculateCurrentPoint(memberId);
        }
        return null;
    }

    @Override
    public Double getRefundPoint(Long memberId, Long storeId, LocalDateTime createdAt, Double refundPoint) {
        // 해당 point 조회해 합계를 계산한다.
        List<Point> completePoint = pointRepository.findCompletePoint(memberId, createdAt);
        Double sumPoint = sumPoint(completePoint);

        // point 합계와 환불하고자 하는 point 합이 동일한 경우
        if(refundPoint.equals(sumPoint)) {
            // 해당 point들의 상태변경
            for (Point point : completePoint) {
                if (isBetween(point.getCreatedAt())) {
                    pointRepository.updateExpiredPoint(point.getId()); // 생성시간이 1년 초과면 만료한다.
                }
                pointRepository.updateRefundPoint(point.getId()); // 생성시간이 1년 미만이면 환불한다.
            }

            // pointhst를 쌓는다.
            PointHst refundPointHst = PointHst.toSave(storeId, memberId, refundPoint);
            pointHstRepository.save(refundPointHst);
        }

        // point 합계와 환불하고자 하는 point 합이 동일하지 않은 경우
        throw new RuntimeException("환불할 포인트의 합계가 일치하지 않습니다.");
    }

    @Override
    public void expiredPoint() {
        List<Point> allPointForExpire = pointRepository.findAllPointForExpire(); // 사용가능 상태인 포인트들을 다 가지고 온다.
        for (Point point : allPointForExpire) {
            pointRepository.updateExpiredPoint(point.getId());
        }
    }


    private Double calculateCurrentPoint(Long memberId) {
        List<Point> points = pointReader.findAbleToUsePoint(memberId);
        Double pointValue = 0.0;
        for (Point point : points) {
            pointValue += point.getValue();
        }

        return pointValue;
    }

    private Double sumPoint(List<Point> points) {
        Double sum = 0.0;
        for (Point point : points) {
            sum += point.getValue();
        }
        return sum;
    }

    private Boolean isBetween(LocalDateTime localDateTime) {
        LocalDate line = LocalDate.now().minusYears(1).minusDays(1);
        if (localDateTime.isAfter(LocalDateTime.of(line, LocalTime.MIN)) && localDateTime.isBefore(LocalDateTime.of(line, LocalTime.MAX))) {
            return true;
        }
        return false;
    }

}
