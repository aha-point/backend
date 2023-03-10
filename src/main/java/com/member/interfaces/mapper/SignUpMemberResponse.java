package com.member.interfaces.mapper;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;

@Data
@Getter
@Builder
public class SignUpMemberResponse {
    private Boolean result; // true 성공, false 실패
}
