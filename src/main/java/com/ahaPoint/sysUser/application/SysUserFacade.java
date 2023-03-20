package com.ahaPoint.sysUser.application;

import com.ahaPoint.sysUser.domain.CheckNumber;
import com.ahaPoint.sysUser.domain.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SysUserFacade {
    private final SysUserService sysUserService;

    public String checkRandomCode(CheckNumber input) {
        return sysUserService.checkRandomCode(input);
    }
}
