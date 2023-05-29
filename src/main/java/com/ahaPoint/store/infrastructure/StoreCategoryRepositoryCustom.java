package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.StoreCategory;

import java.util.List;

public interface StoreCategoryRepositoryCustom {
    List<Long> findByCategoryCode(List<String> categories);

}
