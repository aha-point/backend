package com.member.interfaces.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CheckRandomCodeResponse {
    private String randomCode; // 난수
}
