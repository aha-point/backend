package com.ahaPoint.point.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPointHst is a Querydsl query type for PointHst
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointHst extends EntityPathBase<PointHst> {

    private static final long serialVersionUID = 1676622202L;

    public static final QPointHst pointHst = new QPointHst("pointHst");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> hstId = createNumber("hstId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final EnumPath<PointStatus> status = createEnum("status", PointStatus.class);

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Double> value = createNumber("value", Double.class);

    public QPointHst(String variable) {
        super(PointHst.class, forVariable(variable));
    }

    public QPointHst(Path<? extends PointHst> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPointHst(PathMetadata metadata) {
        super(PointHst.class, metadata);
    }

}

