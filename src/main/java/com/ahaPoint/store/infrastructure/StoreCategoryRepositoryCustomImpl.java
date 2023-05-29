package com.ahaPoint.store.infrastructure;

import com.ahaPoint.point.domain.PointStatus;
import com.ahaPoint.store.domain.StoreCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ahaPoint.point.domain.QPoint.point;
import static com.ahaPoint.store.domain.QStoreCategory.storeCategory;

@Repository
@RequiredArgsConstructor
public class StoreCategoryRepositoryCustomImpl implements StoreCategoryRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Long> findByCategoryCode(List<String> categories) {
        return jpaQueryFactory.selectDistinct(storeCategory.storeId)
                .from(storeCategory)
                .where(storeCategory.categoryCode.in(categories))
                .stream().toList();
    }
}
