package com.ahaPoint.common.domain;

import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUserInput;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageCommand {


    /**
     * save 할때 dto
     */
    @Getter
    @ToString
    @Builder(toBuilder = true)
    @AllArgsConstructor
    public static class Save {

        private String url; // 사진 url
        private String represent; // 대표사진 유무

        public static SysUser toEntity(MemberCommand.Save save, UserType type) {
            return SysUser.entityBuilder()
                    .phoneNumber(save.getPhoneNumber())
                    .password(save.getPassword())
                    .type(type.name())
                    .build();
        }

    }

}
