package com.ahaPoint.member.interfaces.mapper.check_random_code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CheckRandomCodeResponse {
    private String randomCode; // 난수
}
