package com.ahaPoint.store.interfaces;

import com.ahaPoint.common.application.CommonFacade;
import com.ahaPoint.common.domain.Image;
import com.ahaPoint.member.application.MemberFacade;
import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.interfaces.mapper.sign_up_member.SignUserInput;
import com.ahaPoint.point.application.PointFacade;
import com.ahaPoint.store.application.StoreFacade;
import com.ahaPoint.store.domain.StoreCommand;
import com.ahaPoint.store.domain.StoreDto;
import com.ahaPoint.sysUser.application.SysUserFacade;
import com.ahaPoint.sysUser.domain.SysUser;
import com.ahaPoint.sysUser.domain.SysUserCommand;
import com.ahaPoint.sysUser.interfaces.CheckPhoneNumber;
import com.ahaPoint.sysUser.interfaces.IsDuplicated;
import com.ahaPoint.sysUser.interfaces.LogInInput;
import com.ahaPoint.sysUser.interfaces.LogInResponse;
import com.ahaPoint.sysUser.interfaces.enums.UserType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StoreRestController {

    private final StoreFacade storeFacade;

    /**
     * 상세정보 저장
     */
    @PostMapping("/store:saveStoreDetailedInfo")
    @Operation(summary = "가게 상세정보 저장", description = "가게들의 상세정보들을 저장하고 변경하는 API입니다.")
    @Transactional
    public void saveStoreDetailedInfo(StoreDetailInfoInput input) {
        storeFacade.upsertStoreDetailedInfo(input);
    }


    /**
     * 일반 회원 - 가게리스트 조회
     */
    @PostMapping("/store:getStoreListByCategory")
    @Operation(summary = "카테고리로 가게 리스트 조회", description = "일반회원들이 카테고리로 가게리스트를 조회하는 api입니다.")
    public List<StoreDto.Store> getStoreListByCategory(CategoryFilter filter) {
        return storeFacade.getStoreListByCategories(filter);
    }

}
