package com.ahaPoint.point.application;

import com.ahaPoint.point.domain.PointDto;
import com.ahaPoint.point.domain.PointReader;
import com.ahaPoint.point.domain.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointFacade {
    private final PointService pointService;

    private final PointReader pointReader;

    public Double getCurrentPoint(String phoneNumber) {
        return pointService.getCurrentPoint(phoneNumber);
    }

    public void savePointWhenSignUp(Long memberId) {
        pointService.savePointWhenSignUp(memberId);
    }

    public Double spendAndEarnPoint(Long storeId, Long memberId, String type, Double spendValue, Double earnValue) {
        return pointService.spendAndEarnPoint(storeId, memberId, type, spendValue, earnValue);
    }

    public List<PointDto.PointDtoForMember> getPointListForMember(Long memberId) {
        return pointReader.findPointListForMember(memberId);
    }

    public List<PointDto.PointDtoForStore> getPointListForStore(Long storeId) {
        return pointReader.findPointListForStore(storeId);
    }

    public void getRefundPoint(Long memberId, Long storeId, LocalDateTime createdAt, Double refundPoint) {
        pointService.getRefundPoint(memberId, storeId, createdAt, refundPoint);
    }

    public void expirePoint() {
        pointService.expiredPoint();
    }

}
