package com.ahaPoint.member.domain;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCommand {

    /**
     * save 할때 dto
     */
    @Getter
    @ToString
    @Builder(toBuilder = true)
    public static class Save {

        private String phoneNumber; // 전화번호 + 아이디
        private String password; // 비밀번호

        private String name; // 이름

        private String email; // 이메일

        private String agreeMarketing;
        private String zipCode; // 우편번호
        private String address; // 주소
    public static Member toEntity(Save save) {
        return Member.entityBuilder()
                .name(save.name)
                .zipCode(save.zipCode)
                .address(save.address)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        }

    }

}
