package com.member.interfaces.query;

import com.member.interfaces.query.*;
import common.util.SendMessageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class MemberQuery {

    private final SendMessageService sendMessageService;

    @GetMapping("/test-send-message")
    public CheckRandomCodeResponse checkRandomCode(CheckRandomCodeInput checkRandomCodeInput) {
        return CheckRandomCodeResponse.of(sendMessageService.sendMessage(checkRandomCodeInput));
    }

    @GetMapping
    @RequestMapping("/test")
    public String test() {
        return "plz123123123";
    }


    public Boolean checkMemberIdDuplication(CheckMemberIdDuplicationInput checkMemberIdDuplicationInput) {
        return true;
    }

    @PostMapping("/test")
    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return new GetMemberByPhoneNumberResponse("userImage", "jiaLEE", "01099735424", 1);
    }
}
