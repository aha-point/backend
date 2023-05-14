package com.ahaPoint.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class MemberInfo {

    @Data
    @AllArgsConstructor
    @Builder
    public static class Member {

        private Long id; // sysUser Id (pk)
        private String name; // 이름
        private String email; // 이메일
        private String zipCode; // 우편번호
        private String address; // 주소
        private LocalDateTime createdAt; // 생성시간
        private LocalDateTime updatedAt; // 수정시간

        public static Member of(com.ahaPoint.member.domain.Member member) {
            return Member.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .zipCode(member.getZipCode())
                    .address(member.getAddress())
                    .createdAt(member.getCreatedAt())
                    .updatedAt(member.getUpdatedAt())
                    .build();
        }
    }
}
