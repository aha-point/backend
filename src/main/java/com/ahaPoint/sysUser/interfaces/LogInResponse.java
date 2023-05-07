package com.ahaPoint.sysUser.interfaces;

import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class LogInResponse {
    private Boolean result;
    private UserType userType;
    private String token;
}
