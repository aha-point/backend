package com.ahaPoint.store.infrastructure;

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

    @Override
    public List<StoreDto.Store> getStoreListByCategoriesAndKeyword(CategoryFilter filter) {
        return storeCategoryRepository.findByCategoryCodeAndKeyword(filter.getCategories(), filter.getKeyWord());

    }
}
