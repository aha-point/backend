package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointStatus;
import com.ahaPoint.point.domain.QPoint;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.ahaPoint.point.domain.QPoint.point;
import static com.ahaPoint.store.domain.QStore.store;

@Repository
@RequiredArgsConstructor
public class PointRepositoryCustomImpl implements PointRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void updatePointComplete(Point point, Long storeId) {
        jpaQueryFactory.update(QPoint.point)
                .set(QPoint.point.status, PointStatus.COMPLETE)
                .set(QPoint.point.updatedAt, LocalDateTime.now())
                .where(QPoint.point.id.eq(point.getId()))
                .execute();
    }

    @Override
    public void updateDividePointComplete(Point point, Integer value) { // 기존 point에서 사용완료 한 만큼
        jpaQueryFactory.update(QPoint.point)
                .set(QPoint.point.status, PointStatus.COMPLETE)
                .set(QPoint.point.updatedAt, LocalDateTime.now())
                .set(QPoint.point.value, value)
                .where(QPoint.point.id.eq(point.getId()))
                .execute();
    }

    @Override
    public List<Point> findAbleToUsePoint(Long memberId) {
        return jpaQueryFactory.select(point)
                .from(point)
                .where(point.status.in(PointStatus.UNUSED, PointStatus.REFUND)
                        .and(point.memberId.eq(memberId))
                )
                .orderBy(point.createdAt.asc())
                .stream().toList();
    }


}
