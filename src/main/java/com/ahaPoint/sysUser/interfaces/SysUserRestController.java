package com.ahaPoint.sysUser.interfaces;

import com.ahaPoint.member.interfaces.mapper.check_member_id_duplication.CheckMemberIdDuplicationInput;
import com.ahaPoint.sysUser.domain.CheckNumber;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeInput;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeResponse;
import com.ahaPoint.sysUser.application.SysUserFacade;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SysUserRestController {

    private final SysUserFacade sysUserFacade;

    /**
     * 회원가입시, 전화번호 확인용 문자발송
     */
    @PostMapping("/sysUser:sendSignUpMessage")
    @Operation(summary = "핸드폰 인증 난수 발송", description = "일반유저가 회원가입시 핸드폰인증을 위해 난수를 발송하는 API 입니다.")
    public CheckRandomCodeResponse checkRandomCode(CheckRandomCodeInput checkRandomCodeInput) {
        CheckNumber number = checkRandomCodeInput.toCriteria(checkRandomCodeInput);
        String code =  sysUserFacade.checkRandomCode(number);
        return CheckRandomCodeResponse.of(code);
    }

    /**
     * 중복유저 확인
     */
    @PostMapping("/sysUser:checkMemberIdDuplicated")
    @Operation(summary = "중복회원 확인", description = "일반유저가 중복된 전화번호(아이디)가 있는지 확인하는 API 입니다.")
    public Boolean checkMemberIdDuplication(CheckMemberIdDuplicationInput checkMemberIdDuplicationInput) {
        return true;
    }

}
