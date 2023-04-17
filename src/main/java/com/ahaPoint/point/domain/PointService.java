package com.ahaPoint.point.domain;

import com.ahaPoint.point.interfaces.enums.ProcessType;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface PointService {

    Integer getCurrentPoint(String phoneNumber);

    void savePointWhenSignUp(Long memberId);

    Integer updatePoint(Long storeId, Long memberId, ProcessType type, Integer spendValue, Integer earnValue);
}
