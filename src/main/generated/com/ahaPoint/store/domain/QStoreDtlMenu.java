package com.ahaPoint.store.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreDtlMenu is a Querydsl query type for StoreDtlMenu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreDtlMenu extends EntityPathBase<StoreDtlMenu> {

    private static final long serialVersionUID = -1288067604L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreDtlMenu storeDtlMenu = new QStoreDtlMenu("storeDtlMenu");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath menu = createString("menu");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final QStore store;

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public QStoreDtlMenu(String variable) {
        this(StoreDtlMenu.class, forVariable(variable), INITS);
    }

    public QStoreDtlMenu(Path<? extends StoreDtlMenu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreDtlMenu(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreDtlMenu(PathMetadata metadata, PathInits inits) {
        this(StoreDtlMenu.class, metadata, inits);
    }

    public QStoreDtlMenu(Class<? extends StoreDtlMenu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

