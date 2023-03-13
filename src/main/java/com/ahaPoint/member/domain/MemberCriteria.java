package com.ahaPoint.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberCriteria {

    @Builder
    @Getter
    public static class MemberInfo {

        private Long id; // sysUser Id (pk)
        private String phoneNumber; // 아이디 겸 전화번호
        private String password; // 패스워드
        private String name; // 이름
        private String email; // 이메일
        private String zipCode; // 우편번호
        private String address; // 주소
        private LocalDateTime createdAt; // 생성시간
        private LocalDateTime updatedAt; // 수정시간

    }
}
