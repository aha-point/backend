package com.ahaPoint.sysUser.application;

import com.ahaPoint.sysUser.domain.CheckNumber;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.domain.SysUserService;
import com.ahaPoint.sysUser.interfaces.LogInInput;
import com.ahaPoint.sysUser.interfaces.LogInResponse;
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

    public SysUser saveSysUser(SysUserCommand.Save save) {
        return sysUserService.saveSysUser(save);
    }

    public Boolean isDuplicated(String phoneNumber) {
        return sysUserService.isDuplicated(phoneNumber);
    }

    public LogInResponse signIn(LogInInput input) {
        return sysUserService.signIn(input.getPhoneNumber(), input.getPassword());
    }
}
