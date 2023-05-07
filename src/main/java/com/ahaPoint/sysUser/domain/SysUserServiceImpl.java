package com.ahaPoint.sysUser.domain;

import com.ahaPoint.common.util.SendMessageService;
import com.ahaPoint.jwt.JwtUtil;
import com.ahaPoint.sysUser.infrastructure.SysUserRepository;
import com.ahaPoint.sysUser.interfaces.LogInResponse;
import com.ahaPoint.sysUser.interfaces.SysUserRestController;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService{

    private final long VALID_MILISECOND = 1000L * 60 * 60; // 1 시간

    @Value("${jwt.secret}")
    private String secretKey;

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

    @Override
    public LogInResponse signIn(String phoneNumber, String password) {
        // id와 password 로 user정보 가지고 오기
        Optional<SysUser> user = sysUserRepository.findByPhoneNumberAndPassword(phoneNumber, password);
        if (user.isEmpty()) {
            throw new RuntimeException("해당 유저가 존재하지 않습니다.");
        }

        String token = JwtUtil.createToken(phoneNumber, secretKey, VALID_MILISECOND);

        return LogInResponse.builder()
                .result(Boolean.TRUE)
                .userType(UserType.of(user.get().getType()))
                .token(token)
                .build();
    }
}
