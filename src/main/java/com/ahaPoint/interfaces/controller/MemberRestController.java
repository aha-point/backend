package com.ahaPoint.interfaces.controller;

import com.ahaPoint.interfaces.mapper.*;
import com.ahaPoint.common.util.SendMessageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {
    private final SendMessageService sendMessageService;

    @PostMapping(":signUpMember")
    @Operation(summary = "회원가입", description = "일반유저가 회원가입하는 메소드입니다.")
    public SignUpMemberResponse signUpMember(SignUpMemberInput signUpMemberInput) {
        return null;
    }

    public CheckRandomCodeResponse checkRandomCode(CheckRandomCodeInput checkRandomCodeInput) {
        return CheckRandomCodeResponse.of(sendMessageService.sendMessage(checkRandomCodeInput));
    }

    public Boolean checkMemberIdDuplication(CheckMemberIdDuplicationInput checkMemberIdDuplicationInput) {
        return true;
    }


    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return new GetMemberByPhoneNumberResponse("userImage", "jiaLEE", "01099735424", 1);
    }
}
