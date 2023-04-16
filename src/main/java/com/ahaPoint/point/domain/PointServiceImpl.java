package com.ahaPoint.point.domain;

import com.ahaPoint.point.application.PointFacade;
import com.ahaPoint.point.infrastructure.PointRepository;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.infrastructure.SysUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointServiceImpl implements PointService{

    private final PointRepository pointRepository;

    private final SysUserRepository sysUserRepository;

    private final String EVENT_POINT_SIGN_UP = "1000";

    @Override
    public Integer getCurrentPoint(String phoneNumber) {
        SysUser sysUser = sysUserRepository.findByPhoneNumber(phoneNumber);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new RuntimeException("해당 사용자가 존재하지 않습니다.");
        }

        List<Point> points = pointRepository.findByMemberIdAndStatus(sysUser.getMember().getMemberId(), PointStatus.UNUSED.name());
        Integer pointValue = 0;
        for (Point point : points) {
            pointValue += Integer.valueOf(point.getValue());
        }

        return pointValue;
    }

    @Override
    public void savePointWhenSignUp(Long memberId) {
        Point pointEntity = Point.entityBuilder()
                .memberId(memberId)
                .value(EVENT_POINT_SIGN_UP)
                .status(PointStatus.UNUSED)
                .createdAt(LocalDateTime.now())
                .build();
        pointRepository.save(pointEntity);
    }

    private Integer calculatePoint(String phoneNumber) {
        return null;
    }
}
