package com.ahaPoint.member.domain;


public interface MemberService {

    void saveMember(MemberCommand.Save save);


    MemberInfo.Member getMemberInfo(String phoneNumber);
}
