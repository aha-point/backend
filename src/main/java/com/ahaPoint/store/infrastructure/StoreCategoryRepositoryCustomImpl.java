package com.ahaPoint.store.infrastructure;

import com.ahaPoint.point.domain.PointStatus;
import com.ahaPoint.store.domain.Store;
import com.ahaPoint.store.domain.StoreCategory;
import com.ahaPoint.store.domain.StoreDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ahaPoint.point.domain.QPoint.point;
import static com.ahaPoint.store.domain.QStore.store;
import static com.ahaPoint.store.domain.QStoreCategory.storeCategory;

@Repository
@RequiredArgsConstructor
public class StoreCategoryRepositoryCustomImpl implements StoreCategoryRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<StoreDto.Store> findByCategoryCodeAndKeyword(List<String> categories, String keyword) {
        String word = "%" + keyword + "%";

        return jpaQueryFactory.select(
                    Projections.constructor(
                        StoreDto.Store.class,
                        store.id.as("storeId"), // 이 방식일때는 필드명도 무조건 동일해야한다.
                        store.sysId,
                        store.storeName,
                        store.email,
                        store.storePhoneNumber,
                        store.storeAddress,
                        store.storeZipCode,
                        store.storeImageId,
                        store.pointPercentage,
                        store.createdAt,
                        store.updatedAt
                    )
                )
                .from(store)
                .leftJoin(storeCategory)
                .on(store.id.eq(storeCategory.storeId))
                .where(
                        storeCategory.categoryCode.in(categories)
                                .and(store.storeName.contains(word))
                )
                .stream().toList();
    }
}
