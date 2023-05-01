package com.ahaPoint.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "store_dtl_info", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StoreDtlInfo {

    @Id @GeneratedValue
    private Long id; // info pk
    private Long storeId;
    private CommonYn IsTakeOut;
    private CommonYn IsReserve;

    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sysId", insertable = false, updatable = false)
    private Store store;
}
