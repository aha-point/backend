package com.ahaPoint.sysUser.domain;

import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SysUserCommand {

    /**
     * save 할때 dto
     */
    @Getter
    @ToString
    @Builder(toBuilder = true)
    @AllArgsConstructor
    public static class Save {

        private String phoneNumber; // 아이디 겸 핸드폰번호
        private String password; // 비밀번호
        private UserType type; // member or store

        public static SysUser toEntity(SysUserCommand.Save save) {
            return SysUser.entityBuilder()
                    .phoneNumber(save.getPhoneNumber())
                    .password(save.getPassword())
                    .type(save.getType().name())
                    .build();
        }

    }

}
