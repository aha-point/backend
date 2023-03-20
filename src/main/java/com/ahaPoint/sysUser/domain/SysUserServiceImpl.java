package com.ahaPoint.sysUser.domain;

import com.ahaPoint.common.util.SendMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService{

    private final SendMessageService sendMessageService;
    @Override
    public String checkRandomCode(CheckNumber number) {
        return sendMessageService.sendMessage(number);
    }
}
