package com.ahaPoint.member.domain;


public interface MemberService {

    Long saveMember(MemberCommand.Save save);


    MemberInfo.Member getMemberInfo(String phoneNumber);
}
