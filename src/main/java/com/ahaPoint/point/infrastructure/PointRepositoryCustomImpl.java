package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ahaPoint.point.domain.QPoint.point;

@Repository
@RequiredArgsConstructor
public class PointRepositoryCustomImpl implements PointRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

}
