package com.ahaPoint.member.interfaces.controller;

import com.ahaPoint.common.util.SendMessageService;
import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.domain.MemberCriteria;
import com.ahaPoint.member.interfaces.mapper.check_member_id_duplication.CheckMemberIdDuplicationInput;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeInput;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeResponse;
import com.ahaPoint.member.interfaces.mapper.get_member_by_phone_number.GetMemberByPhoneNumberInput;
import com.ahaPoint.member.interfaces.mapper.get_member_by_phone_number.GetMemberByPhoneNumberResponse;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUpMemberInput;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUpMemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberFacade memberFacade;
    private final SendMessageService sendMessageService;

    @PostMapping(":signUpMember")
    @Operation(summary = "회원가입", description = "일반유저가 회원가입하는 메소드입니다.")
    public SignUpMemberResponse signUpMember(SignUpMemberInput input) {
        MemberCommand.Save save = input.toCommand();
        memberFacade.signUpMember(save);

        return null;
    }

    @PostMapping(":sendSignUpMessage")
    public CheckRandomCodeResponse checkRandomCode(CheckRandomCodeInput checkRandomCodeInput) {
        return CheckRandomCodeResponse.of(sendMessageService.sendMessage(checkRandomCodeInput));
    }


    @PostMapping(":checkMemberIdDuplicated")
    public Boolean checkMemberIdDuplication(CheckMemberIdDuplicationInput checkMemberIdDuplicationInput) {
        return true;
    }



    @PostMapping(":getMemberByPhoneNumber")
    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return new GetMemberByPhoneNumberResponse("userImage", "jiaLEE", "01099735424", 1);
    }
}
