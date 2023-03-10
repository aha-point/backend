package com.member.interfaces.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetMemberByPhoneNumberInput {
    private String phoneNumber; // 핸드폰 번호
}
