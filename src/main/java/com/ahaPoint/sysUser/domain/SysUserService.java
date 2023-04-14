package com.ahaPoint.sysUser.domain;

public interface SysUserService {

    String checkRandomCode(CheckNumber number);

    SysUser saveSysUser(SysUserCommand.Save save);

    Boolean isDuplicated(String phoneNumber);
}
