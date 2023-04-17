package com.ahaPoint.sysUser.domain;

import com.ahaPoint.common.util.SendMessageService;
import com.ahaPoint.sysUser.infrastructure.SysUserRepository;
import com.ahaPoint.sysUser.interfaces.SysUserRestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService{

    private final SendMessageService sendMessageService;

    private final SysUserRepository sysUserRepository;
    @Override
    public String checkRandomCode(CheckNumber number) {
        return sendMessageService.sendMessage(number);
    }

    @Override
    public SysUser saveSysUser(SysUserCommand.Save save) {
        SysUser saveSysUser = SysUserCommand.Save.toEntity(save);
        return sysUserRepository.save(saveSysUser);
    }

    @Override
    public Boolean isDuplicated(String phoneNumber) {
        Optional<SysUser> byPhoneNumber = sysUserRepository.findByPhoneNumber(phoneNumber);

        if (byPhoneNumber.isEmpty()) { // 중복아님
            return false;
        }
        return true; // 중복
    }
}
