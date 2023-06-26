package com.ahaPoint.sysUser.interfaces;

import com.ahaPoint.common.application.CommonFacade;
import com.ahaPoint.common.domain.Image;
import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUserInput;
import com.ahaPoint.point.application.PointFacade;
import com.ahaPoint.store.application.StoreFacade;
import com.ahaPoint.store.domain.StoreCommand;
import com.ahaPoint.sysUser.application.SysUserFacade;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
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
    private final PointFacade pointFacade;


    /**
     * 회원가입
     */
    @PostMapping("/sysUser:signUp")
    @Operation(summary = "회원가입", description = "회원가입하는 API입니다.")
    @Transactional
    public void signUpSysUser(SignUserInput input) {
        // sysUser 저장
        SysUserCommand.Save save = SignUserInput.toSysUserCommand(input);
        SysUser sysUser = sysUserFacade.saveSysUser(save);

        // store 하고 저장
        if (UserType.STORE == UserType.of(sysUser.getType())) {
            // 사진 먼저 저장
            Image image = commonFacade.saveImage(SignUserInput.toImageCommand(input));

            // store 저장
            input.setImageId(image.getId());
            input.setSysUserId(sysUser.getId());
            StoreCommand.Save storeSave = SignUserInput.toStoreCommand(input);
            Long saveStoreId = storeFacade.saveStore(storeSave);

            // category 저장
            storeFacade.upsertStoreCategory(saveStoreId, input.getCategories());
        }

        if (UserType.MEMBER == UserType.of(sysUser.getType())) {
            // member 저장
            input.setSysUserId(sysUser.getId());
            MemberCommand.Save memberSave = SignUserInput.toMemberCommand(input);
            Long saveMemberId = memberFacade.saveMember(memberSave);
            pointFacade.savePointWhenSignUp(saveMemberId);
        }

    }


    /**
     * 로그인
     */
    @PostMapping("/sysUser:logIn")
    @Operation(summary = "로그인", description = "로그인하는 API입니다.")
    public LogInResponse logInSysUser(LogInInput input) {
        return sysUserFacade.signIn(input);

    }

    /**
     * 로그인
     */
    @PostMapping("/sysUser:logIn2")
    @Operation(summary = "로그인", description = "로그인하는 API입니다.")
    public LogInResponse logIn(LogInInput input) {
        return sysUserFacade.signIn(input);

    }

    /**
     * 중복 체크(전화번호)
     */
    @PostMapping("/sysUser:checkDuplicated")
    @Operation(summary = "아이디 중복체크", description = "아이디(전화번호) 중복을 체크하는 API입니다.")
    public CheckPhoneNumber isDuplicated(String phoneNumber) {
        Boolean result = sysUserFacade.isDuplicated(phoneNumber);
        return CheckPhoneNumber.of(IsDuplicated.getIsDuplicated(result));
    }

}
