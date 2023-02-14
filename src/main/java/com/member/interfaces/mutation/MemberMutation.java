package com.member.interfaces.mutation;

import com.member.interfaces.query.CheckMemberIdDuplicationInput;
import com.member.interfaces.query.GetMemberByPhoneNumberInput;
import com.member.interfaces.query.GetMemberByPhoneNumberResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberMutation {

    public SignUpMemberResponse signUpMember(SignUpMemberInput signUpMemberInput) {
        return null;
    }

}
