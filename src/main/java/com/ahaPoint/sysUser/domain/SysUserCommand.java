package com.ahaPoint.sysUser.domain;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SysUserCommand {

    /**
     * save 할때 dto
     */
    @Getter
    @ToString
    @Builder(toBuilder = true)
    public static class Save {
        private String phoneNumber; // 아이디 겸 핸드폰번호
        private String password; // 비밀번호
    }
}
