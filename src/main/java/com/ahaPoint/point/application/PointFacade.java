package com.ahaPoint.point.application;

import com.ahaPoint.point.domain.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointFacade {
    private final PointService pointService;

    public Integer getCurrentPoint(String phoneNumber) {
        return pointService.getCurrentPoint(phoneNumber);
    }

    public void savePointWhenSignUp(Long memberId) {
        pointService.savePointWhenSignUp(memberId);
    }

}
