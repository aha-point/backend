package com.ahaPoint.member.interfaces.controller;

import com.ahaPoint.member.interfaces.mapper.get_member_by_phone_number.GetMemberByPhoneNumberInput;
import com.ahaPoint.member.interfaces.mapper.get_member_by_phone_number.GetMemberByPhoneNumberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberRestController {


    //@PostMapping(":getMemberByPhoneNumber")
    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return new GetMemberByPhoneNumberResponse("userImage", "jiaLEE", "01099735424", 1);
    }
}
