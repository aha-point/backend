package com.member.interfaces.query;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckRandomCodeResponse {
    private String randomCode; // 난수
}
