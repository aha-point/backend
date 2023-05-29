package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.Store;
import com.ahaPoint.store.domain.StoreCategory;
import com.ahaPoint.store.domain.StoreDto;
import com.ahaPoint.store.domain.StoreReader;
import com.ahaPoint.store.interfaces.CategoryFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoreReaderImpl implements StoreReader {

    private final StoreCategoryRepository storeCategoryRepository;

    private final StoreRepository storeRepository;

    @Override
    public List<StoreDto.Store> getStoreListByCategories(CategoryFilter filter) {
        List<Long> storeIds = storeCategoryRepository.findByCategoryCode(filter.getCategories());
        return storeRepository.findByIds(storeIds);
    }
}
