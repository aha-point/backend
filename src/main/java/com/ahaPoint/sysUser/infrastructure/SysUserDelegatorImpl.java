package com.ahaPoint.sysUser.infrastructure;

import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserDelegator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SysUserDelegatorImpl implements SysUserDelegator {

    private SysUserRepository sysUserRepository;

    @Override
    public SysUser saveSysUser(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }
}
