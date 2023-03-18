package com.ahaPoint.member.domain;

import com.ahaPoint.member.infrastructure.MemberRepository;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.domain.SysUserDelegator;
import com.ahaPoint.sysUser.domain.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private MemberStore memberStore;
    private MemberRepository memberRepository;
    private SysUserDelegator sysUserDelegator;

    @Override
    public Boolean signUpMember(MemberCommand.Save save) {

        SysUser toSaveSysUser = SysUserCommand.Save.toEntity(save, UserType.MEMBER);
        SysUser saved = sysUserDelegator.saveSysUser(toSaveSysUser);

        // 저장된 sysUser의 id를 member id 로 set한다.
        Member member = MemberCommand.toEntity(save);
        member.setId(saved.getId());

        return memberStore.SignUpMember(member);
    }
}
