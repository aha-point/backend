package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.Store;
import com.ahaPoint.store.domain.StoreDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ahaPoint.store.domain.QStore.store;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryCustomImpl implements StoreRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<StoreDto.Store> findByIds(List<Long> ids) {
        return jpaQueryFactory.select(Projections.constructor(
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
                ))
                .from(store)
                .where(store.id.in(ids))
                .fetch()
                .stream().toList();
    }
}
