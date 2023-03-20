package com.ahaPoint.member.interfaces.controller;

import com.ahaPoint.common.util.SendMessageServiceImpl;
import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCommand;
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
@RequestMapping("/api")
public class MemberRestController {

    private final MemberFacade memberFacade;
    private final SendMessageServiceImpl sendMessageService;

    @PostMapping("/member:signUpMember")
    @Operation(summary = "member 회원가입", description = "member가 회원가입하는 API입니다.")
    public SignUpMemberResponse signUpMember(SignUpMemberInput input) {
        MemberCommand.Save save = input.toCommand();
        memberFacade.signUpMember(save);

        return null;
    }


    //@PostMapping(":getMemberByPhoneNumber")
    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return new GetMemberByPhoneNumberResponse("userImage", "jiaLEE", "01099735424", 1);
    }
}
