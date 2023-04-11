package com.ahaPoint.sysUser.interfaces;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogInInput {
    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;
}
