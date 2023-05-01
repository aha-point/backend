package com.ahaPoint.store.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonYn {
    Y("Yes"),
    N("No");

    private final String description;

    public static CommonYn toYn(Boolean b) {
        if (Boolean.TRUE == b) {
            return CommonYn.Y;
        }
        return CommonYn.N;
    }
}
