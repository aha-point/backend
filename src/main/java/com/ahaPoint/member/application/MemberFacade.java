package com.ahaPoint.member.application;

import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.domain.MemberCriteria;

import com.ahaPoint.member.domain.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public Boolean signUpMember(MemberCommand.Save save) {
        return memberService.signUpMember(save);
    }

}
