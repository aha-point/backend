package com.ahaPoint.store.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreDtlInfra is a Querydsl query type for StoreDtlInfra
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreDtlInfra extends EntityPathBase<StoreDtlInfra> {

    private static final long serialVersionUID = -1278823709L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreDtlInfra storeDtlInfra = new QStoreDtlInfra("storeDtlInfra");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<CommonYn> parking = createEnum("parking", CommonYn.class);

    public final EnumPath<CommonYn> pet = createEnum("pet", CommonYn.class);

    public final EnumPath<CommonYn> playground = createEnum("playground", CommonYn.class);

    public final QStore store;

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final EnumPath<CommonYn> wheelchair = createEnum("wheelchair", CommonYn.class);

    public final EnumPath<CommonYn> wifi = createEnum("wifi", CommonYn.class);

    public QStoreDtlInfra(String variable) {
        this(StoreDtlInfra.class, forVariable(variable), INITS);
    }

    public QStoreDtlInfra(Path<? extends StoreDtlInfra> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreDtlInfra(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreDtlInfra(PathMetadata metadata, PathInits inits) {
        this(StoreDtlInfra.class, metadata, inits);
    }

    public QStoreDtlInfra(Class<? extends StoreDtlInfra> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

