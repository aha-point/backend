package com.ahaPoint.store.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "store_dtl_menu", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class StoreDtlMenu {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // menu pk
    private Long storeId; // store의 pk
    private String menu; // 메뉴
    private Integer price; // 가격

    /* ============ <연관관계> ============ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sysId")
    private Store store;
}
