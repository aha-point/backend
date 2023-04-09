package com.ahaPoint.sysUser.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogInResponse {
    private Boolean result;
    private String token;
}
