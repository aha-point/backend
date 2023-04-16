package com.ahaPoint.point.application;

import com.ahaPoint.point.domain.PointService;
import com.ahaPoint.sysUser.domain.CheckNumber;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.domain.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointFacade {
    private final PointService pointService;

    public Integer getCurrentPoint(String phoneNumber) {
        return pointService.getCurrentPoint(phoneNumber);
    }

}
