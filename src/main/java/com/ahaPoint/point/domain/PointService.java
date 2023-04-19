package com.ahaPoint.point.domain;

public interface PointService {

    Integer getCurrentPoint(String phoneNumber);

    void savePointWhenSignUp(Long memberId);

    Integer spendAndEarnPoint(Long storeId, Long memberId, String type, Integer spendValue, Integer earnValue);
}
