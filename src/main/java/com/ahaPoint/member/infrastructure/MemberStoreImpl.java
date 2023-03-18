package com.ahaPoint.member.infrastructure;

import com.ahaPoint.member.domain.Member;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.domain.MemberStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {

    private MemberRepository memberRepository;

    @Override
    public Boolean SignUpMember(Member member) {
        memberRepository.save(member);
       return true;
    }
}
