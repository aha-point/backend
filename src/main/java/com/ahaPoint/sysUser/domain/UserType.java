package com.ahaPoint.sysUser.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
    MEMBER("일반회원"),
    STORE("가게회원");

    private final String description;
}
