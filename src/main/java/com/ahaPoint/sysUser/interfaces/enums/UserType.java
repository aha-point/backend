package com.ahaPoint.sysUser.interfaces.enums;

import com.ahaPoint.sysUser.interfaces.IsDuplicated;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
    MEMBER("MEMBER"),
    STORE("STORE");

    private final String description;

    public static UserType of(String userType) {
        if (UserType.MEMBER.toString().equals(userType)) { // 중복
            return UserType.MEMBER;
        }
        return UserType.STORE;
    }
}
