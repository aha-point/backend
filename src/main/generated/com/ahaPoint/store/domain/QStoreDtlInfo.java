package com.ahaPoint.store.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreDtlInfo is a Querydsl query type for StoreDtlInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreDtlInfo extends EntityPathBase<StoreDtlInfo> {

    private static final long serialVersionUID = -1288178373L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreDtlInfo storeDtlInfo = new QStoreDtlInfo("storeDtlInfo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<CommonYn> isReserve = createEnum("isReserve", CommonYn.class);

    public final EnumPath<CommonYn> isTakeOut = createEnum("isTakeOut", CommonYn.class);

    public final QStore store;

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public QStoreDtlInfo(String variable) {
        this(StoreDtlInfo.class, forVariable(variable), INITS);
    }

    public QStoreDtlInfo(Path<? extends StoreDtlInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreDtlInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreDtlInfo(PathMetadata metadata, PathInits inits) {
        this(StoreDtlInfo.class, metadata, inits);
    }

    public QStoreDtlInfo(Class<? extends StoreDtlInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

