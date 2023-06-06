package com.ahaPoint.common.interfaces;

import com.ahaPoint.common.application.CommonFacade;
import com.ahaPoint.common.domain.Image;
import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.interfaces.mapper.check_member_id_duplication.CheckMemberIdDuplicationInput;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeInput;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeResponse;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUserInput;
import com.ahaPoint.store.application.StoreFacade;
import com.ahaPoint.store.domain.StoreCommand;
import com.ahaPoint.sysUser.application.SysUserFacade;
import com.ahaPoint.sysUser.domain.CheckNumber;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ahaPoint.common.util.SendMessageServiceImpl.generate6RandomCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommonRestController {

    private final SysUserFacade sysUserFacade;

    /**
     * 회원가입시, 전화번호 확인용 문자발송
     */
    @PostMapping("/common:sendSignUpMessage")
    @Operation(summary = "핸드폰 인증 난수 발송", description = "일반유저가 회원가입시 핸드폰인증을 위해 난수를 발송하는 API 입니다.")
    public CheckRandomCodeResponse checkRandomCode(CheckRandomCodeInput checkRandomCodeInput) {
        CheckNumber number = checkRandomCodeInput.toCriteria(checkRandomCodeInput);
        String code =  sysUserFacade.checkRandomCode(number);
        return CheckRandomCodeResponse.of(code);
    }

    /**
     * 랜덤 숫자 6개 발송
     */
    @PostMapping("/common:getRandomCode")
    @Operation(summary = "랜덤숫자반환 발송", description = "")
    public CheckRandomCodeResponse getRandomNum(CheckRandomCodeInput checkRandomCodeInput) {
        String randomCode = generate6RandomCode();
        return CheckRandomCodeResponse.of(randomCode);
    }


}
