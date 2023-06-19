package com.ahaPoint.store.application;

import com.ahaPoint.store.domain.*;

//import com.ahaPoint.store.domain.StoreReader;
import com.ahaPoint.store.interfaces.CategoryFilter;
import com.ahaPoint.store.interfaces.StoreDetailInfoInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreFacade {

    private final StoreService storeService;

    private final StoreReader storeReader;


    public Long saveStore (StoreCommand.Save save) {
        return storeService.saveStore(save);
    }

    public void upsertStoreDetailedInfo(StoreDetailInfoInput input) {
        storeService.upsertStoreDetailInfo(input);
    }

    public void upsertStoreCategory(Long storeId, List<String> categories ) {
        storeService.upsertStoreCategory(storeId, categories);
    }

    public List<StoreDto.Store> getStoreListByCategories(CategoryFilter filter) {
        return storeReader.getStoreListByCategoriesAndKeyword(filter);
    }

}
