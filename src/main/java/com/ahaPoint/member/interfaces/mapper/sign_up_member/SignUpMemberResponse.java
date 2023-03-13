package com.ahaPoint.member.interfaces.mapper.sign_up_member;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class SignUpMemberResponse {
    private Boolean result; // true 성공, false 실패
}
