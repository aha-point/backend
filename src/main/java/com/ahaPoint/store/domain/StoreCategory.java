package com.ahaPoint.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "store_category", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StoreCategory {
    @Id
    private Long storeId;
    private String categoryCode;

    /* ============ <연관관계> ============ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sysId")
    private Store store;
}
