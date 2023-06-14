package com.ahaPoint.store.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 1209804911L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> pointPercentage = createNumber("pointPercentage", Integer.class);

    public final StringPath storeAddress = createString("storeAddress");

    public final QStoreDtlInfo storeDtlInfo;

    public final QStoreDtlInfra storeDtlInfra;

    public final ListPath<StoreDtlMenu, QStoreDtlMenu> storeDtlMenus = this.<StoreDtlMenu, QStoreDtlMenu>createList("storeDtlMenus", StoreDtlMenu.class, QStoreDtlMenu.class, PathInits.DIRECT2);

    public final NumberPath<Long> storeImageId = createNumber("storeImageId", Long.class);

    public final StringPath storeName = createString("storeName");

    public final StringPath storePhoneNumber = createString("storePhoneNumber");

    public final StringPath storeZipCode = createString("storeZipCode");

    public final NumberPath<Long> sysId = createNumber("sysId", Long.class);

    public final com.ahaPoint.sysUser.domain.QSysUser sysUser;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.storeDtlInfo = inits.isInitialized("storeDtlInfo") ? new QStoreDtlInfo(forProperty("storeDtlInfo"), inits.get("storeDtlInfo")) : null;
        this.storeDtlInfra = inits.isInitialized("storeDtlInfra") ? new QStoreDtlInfra(forProperty("storeDtlInfra"), inits.get("storeDtlInfra")) : null;
        this.sysUser = inits.isInitialized("sysUser") ? new com.ahaPoint.sysUser.domain.QSysUser(forProperty("sysUser"), inits.get("sysUser")) : null;
    }

}

