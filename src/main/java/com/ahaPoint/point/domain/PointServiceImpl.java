package com.ahaPoint.point.domain;

import com.ahaPoint.point.infrastructure.PointRepository;
import com.ahaPoint.point.interfaces.enums.ProcessType;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.infrastructure.SysUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{

    private final PointRepository pointRepository;

    private final SysUserRepository sysUserRepository;

    private final PointReader pointReader;

    private final Integer EVENT_POINT_SIGN_UP = 1000;

    @Override
    public Integer getCurrentPoint(String phoneNumber) {
        SysUser sysUser = sysUserRepository.findByPhoneNumber(phoneNumber);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new RuntimeException("해당 사용자가 존재하지 않습니다.");
        }

        return calculateCurrentPoint(sysUser.getMember().getMemberId());
    }

    @Override
    public void savePointWhenSignUp(Long memberId) {
        Point toSave = Point.toSave(null, memberId, EVENT_POINT_SIGN_UP);
        pointRepository.save(toSave); // 회원가입시 발급받는 포인트에는 storeId 가 없음.
    }

    @Override
    public Integer updatePoint(Long storeId, Long memberId, ProcessType type, Integer spendValue, Integer earnValue) {
        if (ProcessType.EARN == type) {
            // 적립 - save 하고 현재 사용가능한 포인트를 조회한다.
            Point point = Point.toSave(storeId, memberId, earnValue);
            pointRepository.save(point);
            return calculateCurrentPoint(memberId);
        }

        if (ProcessType.EARN_AND_SPEND == type) {
            // 사용하고 적립한다.
            // 사용한다 - 일단 해당 포인트 사용이 가능한지 확인 -> 안되면 Exception
            Integer currentPoint = calculateCurrentPoint(memberId);
            if (spendValue > currentPoint) {
                throw new RuntimeException("포인트 사용이 불가합니다.");
            }

            // 해당 유저의 포인트를 가지고 온다.
            List<Point> points = pointReader.findAbleToUsePoint(memberId);
            for (Point point : points) {
                Integer value = point.getValue();
                if (spendValue >= value) { // 사용하고자 하는 포인트가 더 크거나 같다.
                    // 그러면 해당 point는 상태값을 변환하고 저장한다.
                    pointRepository.updatePointComplete(point, storeId);
                    spendValue -= value;
                } else { // 사용하고자 하는 포인트가 더 작다. -> 그러면 해당 포인트가 쪼개져서 해당 포인트 만큼 complete된다.
                    // 기존 point 는 devide로 update
                    pointRepository.updatePointDivide(point);

                    // value > spendValue -> spendValue 만큼 complete 분기처리
                    Point updatePoint = Point.toDivideComplete(point, spendValue, storeId);
                    pointRepository.save(updatePoint);

                    // value - spendValue -> 남은 포인트 unUsed 처리
                    Integer unusedPoint = value - spendValue; // 사용안함
                    Point savePoint = Point.toDivideUnused(point, unusedPoint);
                    pointRepository.save(savePoint);
                }
            }
            return calculateCurrentPoint(memberId);
        }
        return null;
    }

    @NotNull
    private Integer calculateCurrentPoint(Long memberId) {
        List<Point> points = pointReader.findAbleToUsePoint(memberId);
        Integer pointValue = 0;
        for (Point point : points) {
            pointValue += Integer.valueOf(point.getValue());
        }

        return pointValue;
    }

}
