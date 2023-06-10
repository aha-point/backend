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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 엔티티라서 필수적인 ID

    private Long storeId;
    private String categoryCode;

    /* ============ <연관관계> ============ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    public static StoreCategory toEntity(Long storeId, String categoryCode) {
        return StoreCategory.entityBuilder()
                .storeId(storeId)
                .categoryCode(categoryCode)
                .build();
    }
}
