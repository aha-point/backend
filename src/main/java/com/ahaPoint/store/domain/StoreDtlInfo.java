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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_DTL_INFO_ID")
    private Long id; // info pk

    @Column(name = "STORE_ID")
    private Long storeId; // storeId
    private CommonYn isTakeOut;
    private CommonYn isReserve;

    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "storeDtlInfo")
    private Store store;
}
