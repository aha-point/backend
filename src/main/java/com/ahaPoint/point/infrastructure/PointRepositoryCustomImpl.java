package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointStatus;
import com.ahaPoint.point.domain.QPoint;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.ahaPoint.point.domain.QPoint.point;

@Repository
@RequiredArgsConstructor
public class PointRepositoryCustomImpl implements PointRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void updatePointComplete(Point point, Long storeId) {
        jpaQueryFactory.update(QPoint.point)
                .set(QPoint.point.spendStoreId, storeId) // 사용한 가게의 pk를 넣는다.
                .set(QPoint.point.status, PointStatus.COMPLETE)
                .set(QPoint.point.updatedAt, LocalDateTime.now())
                .where(QPoint.point.id.eq(point.getId()))
                .execute();
    }

    @Override
    public void updatePointDivide(Point point) { // 기존 point 상태변경
        jpaQueryFactory.update(QPoint.point)
                .set(QPoint.point.status, PointStatus.DIVIDE)
                .set(QPoint.point.updatedAt, LocalDateTime.now())
                .where(QPoint.point.id.eq(point.getId()))
                .execute();
    }

}
