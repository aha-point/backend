package com.ahaPoint.member.domain;

import com.ahaPoint.member.infrastructure.MemberRepository;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.domain.SysUserDelegator;
import com.ahaPoint.sysUser.infrastructure.SysUserRepository;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository;

    private final SysUserRepository sysUserRepository;

    @Override
    public Long saveMember(MemberCommand.Save save) {
        Member member = MemberCommand.Save.toEntity(save);
        Member saveMember = memberRepository.save(member);
        return saveMember.getMemberId();
    }

    @Override
    public MemberInfo.Member getMemberInfo(String phoneNumber) {
        Optional<SysUser> sysUser = sysUserRepository.findByPhoneNumber(phoneNumber);
        if (sysUser.isEmpty()) {
            throw new RuntimeException("해당 유저가 존재하지 않습니다.");
        }

        Optional<Member> memberByMemberId = memberRepository.findMemberById(sysUser.get().getId());

        return MemberInfo.Member.of(memberByMemberId.get());
    }
}
