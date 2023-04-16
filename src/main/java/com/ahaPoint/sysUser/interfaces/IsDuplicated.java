package com.ahaPoint.sysUser.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum IsDuplicated {
    DUPLICATED("중복"),
    NOT_DUPLICATED("중복아님");

    private final String description;

    public static IsDuplicated getIsDuplicated(Boolean value) {
        if (Boolean.TRUE == value) { // 중복
            return DUPLICATED;
        }
        return NOT_DUPLICATED;
    }
}
