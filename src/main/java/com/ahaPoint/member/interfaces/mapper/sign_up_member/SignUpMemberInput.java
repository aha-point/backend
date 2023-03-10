package com.ahaPoint.member.interfaces.mapper.sign_up_member;

import com.ahaPoint.member.domain.MemberCriteria;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpMemberInput {
    @NotBlank
    private String phoneNumber; // 핸드폰 번호이자 아이디
    @NotBlank
    private String password; // 패스워드
    @NotBlank
    private String name; // 이름

    public MemberCriteria.MemberInfo toCriteria() {
        return MemberCriteria.MemberInfo.builder()
                .phoneNumber(phoneNumber)
                .password(password)
                .name(name)
                .build();
    }
}
