package com.ahaPoint.member.domain;

import com.ahaPoint.member.infrastructure.MemberRepository;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.domain.SysUserDelegator;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;

    @Override
    public void saveMember(MemberCommand.Save save) {
        Member member = MemberCommand.Save.toEntity(save);
        memberRepository.save(member);
    }
}
