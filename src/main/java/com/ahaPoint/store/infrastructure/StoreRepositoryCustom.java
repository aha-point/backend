package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.Store;
import com.ahaPoint.store.domain.StoreDto;

import java.util.List;

public interface StoreRepositoryCustom {
    List<StoreDto.Store> findByIds(List<Long> ids);
}
