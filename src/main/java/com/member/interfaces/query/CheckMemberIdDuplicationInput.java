package com.member.interfaces.query;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckMemberIdDuplicationInput {

    private String phoneNumber; // 핸드폰 번호

}
