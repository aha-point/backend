package com.ahaPoint.point.domain;

import java.time.LocalDateTime;

public interface PointService {

    Double getCurrentPoint(String phoneNumber);

    void savePointWhenSignUp(Long memberId);

    Double spendAndEarnPoint(Long storeId, Long memberId, String type, Double spendValue, Double earnValue);

    Double getRefundPoint(Long memberId, Long storeId, LocalDateTime createdAt, Double refundPoint);
}
