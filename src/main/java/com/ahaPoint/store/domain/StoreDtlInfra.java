package com.ahaPoint.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "store_dtl_infra", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StoreDtlInfra {


    @Id @GeneratedValue
    private Long id; // infra pk
    private Long storeId;
    private CommonYn wifi;
    private CommonYn pet;
    private CommonYn parking;
    private CommonYn wheelchair;
    private CommonYn playground;

    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sysId", insertable = false, updatable = false)
    private Store store;
}
