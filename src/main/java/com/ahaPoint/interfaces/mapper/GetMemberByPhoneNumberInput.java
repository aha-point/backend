package com.ahaPoint.interfaces.mapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetMemberByPhoneNumberInput {
    private String phoneNumber; // 핸드폰 번호
}
