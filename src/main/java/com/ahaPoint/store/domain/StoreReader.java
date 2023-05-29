package com.ahaPoint.store.domain;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointDto;
import com.ahaPoint.store.interfaces.CategoryFilter;

import java.util.List;

public interface StoreReader {

    List<StoreDto.Store> getStoreListByCategories(CategoryFilter filter);

}
