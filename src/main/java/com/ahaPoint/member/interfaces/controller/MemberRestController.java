package com.ahaPoint.member.interfaces.controller;

import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCriteria;
import com.ahaPoint.member.domain.MemberInfo;
import com.ahaPoint.member.interfaces.mapper.get_member_by_phone_number.GetMemberByPhoneNumberInput;
import com.ahaPoint.member.interfaces.mapper.get_member_by_phone_number.GetMemberByPhoneNumberResponse;
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

    /**
     * 가게유저 - 전화번호로 일반유저 조회
     */
    @PostMapping("/member:getMemberByPhoneNumber")
    @Operation(summary = "일반유저 조회", description = "포인트 사용/적립을 위해 전화번호로 일반유저를 조회하는 api 입니다.")
    public MemberInfo.Member getMemberInfo(String phoneNumber) {
        return memberFacade.getMemberInfo(phoneNumber);
    }
}
