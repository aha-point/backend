package com.ahaPoint.point.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PointStatus {
    UNUSED("미사용"), // 아직 미사용
    COMPLETE("사용완료"), // 해당 포인트 다 사용
    DIVIDE("사용중"), // 해당 포인트 사용중
    CANCEL("환불"), // 해당 포인트 환불
    EXPIRED("만료됨"); // 생성시간 + 1년 후 만료됨

    private final String description;
}
