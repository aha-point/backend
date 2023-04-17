package com.ahaPoint.point.interfaces.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProcessType {
    EARN("적립"),
    EARN_AND_SPEND("사용하고 적립"),
    REFUND("환불");


    private final String description;

}
