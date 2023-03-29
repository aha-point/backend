package com.ahaPoint.member.interfaces.mapper.sign_up_member;

import com.ahaPoint.common.domain.ImageCommand;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.store.domain.StoreCommand;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUserInput {

    @NotBlank
    private String phoneNumber; // 아이디 겸 전화번호
    @NotBlank
    private String password; // 비밀번호
    @Setter
    private Long SysUserId; // sysUser의 pk
    /**
     * member 정보
     */

    private String name; // 이름

    private String email; // 이메일

    private String agreeMarketing; // 이메일 수신 동의

    private String zipCode; // 우편번호
    private String address; // 주소

    /**
     * store 정보
     */
    private String storeName; // 상호명
    private String storePhoneNumber; // 가게번호
    private String storeAddress; // 가게 주소
    private String storeZipCode; // 가게 우편번호
    private Integer pointPercentage; // 포인트 퍼센트
    @Setter
    private Long imageId; // 가게대표사진

    private String url; // 사진 url
    private String represent; // 대표사진

    public static MemberCommand.Save toMemberCommand(SignUserInput input) { // member command
        return MemberCommand.Save.builder()
                .name(input.getName())
                .email(input.getEmail())
                .address(input.getAddress())
                .agreeMarketing(input.getAgreeMarketing())
                .build();
    }

    public static SysUserCommand.Save toSysUserCommand(SignUserInput input) {
        return SysUserCommand.Save.builder()
                .phoneNumber(input.getPhoneNumber())
                .password(input.getPassword())
                .type(setUserType(input))
                .build();
    }

    public static StoreCommand.Save toStoreCommand(SignUserInput input) {
        return StoreCommand.Save.builder()
                .storeName(input.getStoreName())
                .storePhoneNumber(input.getStorePhoneNumber())
                .storeAddress(input.getStoreAddress())
                .storeZipCode(input.getZipCode())
                .pointPercentage(input.getPointPercentage())
                .email(input.getEmail())
                .build();
    }

    public static ImageCommand.Save toImageCommand(SignUserInput input) {
        return ImageCommand.Save.builder()
                .url(input.getUrl())
                .represent(input.getRepresent())
                .build();
    }

    private static UserType setUserType(SignUserInput input) {
        if (StringUtils.isNotBlank(input.getStoreName())) {
            return UserType.STORE;
        }
        return UserType.MEMBER;
    }

}
