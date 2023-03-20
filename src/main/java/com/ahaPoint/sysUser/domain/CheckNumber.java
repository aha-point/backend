package com.ahaPoint.sysUser.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
public class CheckNumber {
    private String phoneNumber; // 핸드폰 번호
}
