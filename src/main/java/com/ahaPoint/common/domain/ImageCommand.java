package com.ahaPoint.common.domain;

import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUserInput;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

        public static Image toEntity(ImageCommand.Save save) {
            return Image.entityBuilder()
                    .url(save.getUrl())
                    .represent(save.getRepresent())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }

    }

}
