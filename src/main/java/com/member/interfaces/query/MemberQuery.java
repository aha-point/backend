package com.member.interfaces.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberQuery {

    public Boolean checkMemberIdDuplication(CheckMemberIdDuplicationInput checkMemberIdDuplicationInput) {
        return true;
    }


    public GetMemberByPhoneNumberResponse getMemberByPhoneNumber(GetMemberByPhoneNumberInput getMemberByPhoneNumberInput) {
        return null;
    }
}
