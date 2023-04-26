package com.ahaPoint.sysUser.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSysUser is a Querydsl query type for SysUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSysUser extends EntityPathBase<SysUser> {

    private static final long serialVersionUID = -1264319153L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSysUser sysUser = new QSysUser("sysUser");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.ahaPoint.member.domain.QMember member;

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final com.ahaPoint.store.domain.QStore store;

    public final StringPath type = createString("type");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QSysUser(String variable) {
        this(SysUser.class, forVariable(variable), INITS);
    }

    public QSysUser(Path<? extends SysUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSysUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSysUser(PathMetadata metadata, PathInits inits) {
        this(SysUser.class, metadata, inits);
    }

    public QSysUser(Class<? extends SysUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.ahaPoint.member.domain.QMember(forProperty("member"), inits.get("member")) : null;
        this.store = inits.isInitialized("store") ? new com.ahaPoint.store.domain.QStore(forProperty("store"), inits.get("store")) : null;
    }

}

