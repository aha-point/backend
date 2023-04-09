package com.ahaPoint.sysUser.interfaces;

import com.ahaPoint.common.application.CommonFacade;
import com.ahaPoint.common.domain.Image;
import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.interfaces.mapper.check_member_id_duplication.CheckMemberIdDuplicationInput;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUserInput;
import com.ahaPoint.store.application.StoreFacade;
import com.ahaPoint.store.domain.StoreCommand;
import com.ahaPoint.sysUser.domain.CheckNumber;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeInput;
import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeResponse;
import com.ahaPoint.sysUser.application.SysUserFacade;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SysUserRestController {

    private final CommonFacade commonFacade;
    private final SysUserFacade sysUserFacade;
    private final StoreFacade storeFacade;

    private final MemberFacade memberFacade;


    /**
     * 회원가입
     */
    @PostMapping("/sysUser:signUp")
    @Operation(summary = "회원가입", description = "회원가입하는 API입니다.")
    public void signUpSysUser(SignUserInput input) {

        // 사진 먼저 저장
        Image image = commonFacade.saveImage(SignUserInput.toImageCommand(input));

        // sysUser 저장
        SysUserCommand.Save save = SignUserInput.toSysUserCommand(input);
        SysUser sysUser = sysUserFacade.saveSysUser(save);

        // store 하고 저장
        if (sysUser.getType().equals(UserType.STORE)) {
            // 사진의 아이디 저장
            input.setImageId(image.getId());
            input.setSysUserId(sysUser.getId());
            StoreCommand.Save storeSave = SignUserInput.toStoreCommand(input);
            storeFacade.saveStore(storeSave);
        }

        // member 저장
        input.setSysUserId(sysUser.getId());
        MemberCommand.Save memberSave = SignUserInput.toMemberCommand(input);
        memberFacade.saveMember(memberSave);
    }


    /**
     * 로그인
     */
    @PostMapping("/sysUser:logIn")
    @Operation(summary = "로그인", description = "로그인하는 API입니다.")
    public LogInResponse logInSysUser(LogInInput input) {
        return null;
    }

}
