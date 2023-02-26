package com.member.interfaces.query;

import common.util.SendMessageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequiredArgsConstructor
@Getter
@RestController
@RequestMapping("/member")
public class MemberQuery {

    private final SendMessageService sendMessageService;

    public CheckRandomCodeResponse checkRandomCode(CheckRandomCodeInput checkRandomCodeInput) {
        sendMessageService.
        return null;
    }


    public Boolean checkMemberIdDuplication(CheckMemberIdDuplicationInput checkMemberIdDuplicationInput) {
        return true;
    }

    @PostMapping("/test")
    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return new GetMemberByPhoneNumberResponse("userImage", "jiaLEE", "01099735424", 1);
    }
}
