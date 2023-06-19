package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.StoreDto;

import java.util.List;

public interface StoreCategoryRepositoryCustom {
    List<StoreDto.Store> findByCategoryCodeAndKeyword(List<String> categories, String keyword);

}
