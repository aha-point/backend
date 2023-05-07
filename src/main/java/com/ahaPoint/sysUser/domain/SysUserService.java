package com.ahaPoint.sysUser.domain;

import com.ahaPoint.sysUser.interfaces.LogInResponse;

public interface SysUserService {

    String checkRandomCode(CheckNumber number);

    SysUser saveSysUser(SysUserCommand.Save save);

    Boolean isDuplicated(String phoneNumber);

    LogInResponse signIn(String phoneNumber, String password);
}
