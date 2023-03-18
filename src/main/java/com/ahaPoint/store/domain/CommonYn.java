package com.ahaPoint.store.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonYn {
    Y("Yes"),
    N("No");

    private final String description;
}
