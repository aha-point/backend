package com.ahaPoint.store.domain;

import com.ahaPoint.store.interfaces.CategoryFilter;

import java.util.List;

public interface StoreReader {

    List<StoreDto.Store> getStoreListByCategoriesAndKeyword(CategoryFilter filter);

}
