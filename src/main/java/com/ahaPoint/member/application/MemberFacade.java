package com.ahaPoint.member.application;

import com.ahaPoint.member.domain.MemberCommand;

import com.ahaPoint.member.domain.MemberInfo;
import com.ahaPoint.member.domain.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public void saveMember(MemberCommand.Save save) {
        memberService.saveMember(save);
    }

    public MemberInfo.Member getMemberInfo(String phoneNumber) {
        return memberService.getMemberInfo(phoneNumber);
    }

}
