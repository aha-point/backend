package com.ahaPoint.point.application;

import com.ahaPoint.point.domain.PointDto;
import com.ahaPoint.point.domain.PointReader;
import com.ahaPoint.point.domain.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointFacade {
    private final PointService pointService;

    private final PointReader pointReader;

    public Integer getCurrentPoint(String phoneNumber) {
        return pointService.getCurrentPoint(phoneNumber);
    }

    public void savePointWhenSignUp(Long memberId) {
        pointService.savePointWhenSignUp(memberId);
    }

    public Integer spendAndEarnPoint(Long storeId, Long memberId, String type, Integer spendValue, Integer earnValue) {
        return pointService.spendAndEarnPoint(storeId, memberId, type, spendValue, earnValue);
    }

    public List<PointDto> getPointListForMember(Long memberId) {
        return pointReader.findPointListForMember(memberId);
    }

}
