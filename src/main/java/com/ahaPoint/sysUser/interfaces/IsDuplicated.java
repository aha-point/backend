package com.ahaPoint.sysUser.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.transaction.spi.IsolationDelegate;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor(staticName = "of")
public enum IsDuplicated {
    IS_DUPLICATED("중복"),
    IS_NOT_DUPLICATED("중복아님");

    private final String description;

    public static IsDuplicated getIsDuplicated(Boolean value) {
        if (Boolean.TRUE == value) { // 중복
            return IS_DUPLICATED;
        }
        return IS_NOT_DUPLICATED;
    }
}
