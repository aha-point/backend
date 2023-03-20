package com.ahaPoint.member.interfaces.mapper.check_random_code;

import com.ahaPoint.sysUser.domain.CheckNumber;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckRandomCodeInput {

        private String phoneNumber; // 핸드폰 번호

        @Builder
        public CheckNumber toCriteria(CheckRandomCodeInput input) {
                return CheckNumber.builder()
                        .phoneNumber(input.phoneNumber)
                        .build();

        }
}
