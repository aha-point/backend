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


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_DTL_INFRA_ID")
    private Long id; // infra pk

    @Column(name = "STORE_ID")
    private Long storeId;
    private CommonYn wifi;
    private CommonYn pet;
    private CommonYn parking;
    private CommonYn wheelchair;
    private CommonYn playground;

    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "storeDtlInfra")
    private Store store;
}
