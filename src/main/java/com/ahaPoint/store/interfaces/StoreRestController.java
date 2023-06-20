package com.ahaPoint.store.interfaces;
import com.ahaPoint.store.application.StoreFacade;
import com.ahaPoint.store.domain.StoreDto;
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
    @PostMapping("/store:getStoreListByCategoryAndKeyword")
    @Operation(summary = "카테고리로 가게 리스트 조회", description = "일반회원들이 카테고리와 검색어로 가게리스트를 조회하는 api입니다.")
    @Transactional
    public List<StoreDto.Store> getStoreListByCategoryAndkeyWord(CategoryFilter filter) {
        return storeFacade.getStoreListByCategories(filter);
    }

}
