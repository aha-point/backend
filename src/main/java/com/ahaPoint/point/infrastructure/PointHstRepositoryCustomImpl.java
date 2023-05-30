package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.ahaPoint.member.domain.QMember.member;
import static com.ahaPoint.point.domain.QPoint.point;
import static com.ahaPoint.point.domain.QPointHst.pointHst;
import static com.ahaPoint.store.domain.QStore.store;

@Repository
@RequiredArgsConstructor
public class PointHstRepositoryCustomImpl implements PointHstRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PointDto.PointDtoForMember> findPointListForMember(Long memberId) {
        return jpaQueryFactory
                .select(
                        Projections.constructor(
                                PointDto.PointDtoForMember.class,
                                pointHst.hstId,
                                pointHst.storeId,
                                store.storeName,
                                pointHst.value,
                                pointHst.status,
                                pointHst.createdAt,
                                pointHst.updatedAt
                        )
                )
                .from(pointHst)
                        .leftJoin(store)
                        .on(store.id.eq(pointHst.storeId))
                .where(
                        pointHst.memberId.eq(memberId)
                )
                .orderBy(pointHst.createdAt.desc())
                .fetch();

    }

    @Override
    public List<PointDto.PointDtoForStore> findPointListForStore(Long storeId) {
        return jpaQueryFactory
                .select(
                        Projections.constructor(
                                PointDto.PointDtoForStore.class,
                                pointHst.hstId,
                                pointHst.memberId,
                                member.name,
                                store.id,
                                store.storeName,
                                pointHst.value,
                                pointHst.status,
                                pointHst.createdAt,
                                pointHst.updatedAt
                        )
                )
                .from(pointHst)
                .join(store)
                .on(store.id.eq(pointHst.storeId))
                .join(member)
                .on(member.id.eq(pointHst.memberId))
                .where(
                        pointHst.storeId.eq(storeId)
                )
                .orderBy(pointHst.createdAt.desc())
                .fetch();
    }
}
