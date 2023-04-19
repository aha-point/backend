package com.ahaPoint.point.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "point_hst", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PointHst {

    @Id @GeneratedValue
    private Long hstId; // point Pk
    private Long memberId; // member Id
    private Long storeId; // 적립 혹은 사용한 store
    @NotBlank
    private Integer value; // point 값
    private PointStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PointHst toSave(Long storeId, Long memberId, Integer value) { // 적립
        return PointHst.entityBuilder()
                .memberId(memberId)
                .storeId(storeId)
                .value(value)
                .status(PointStatus.UNUSED)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static PointHst toSpend(Long storeId, Long memberId, Integer value) { // 사용
        return PointHst.entityBuilder()
                .memberId(memberId)
                .storeId(storeId)
                .value(value)
                .status(PointStatus.COMPLETE)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static PointHst toRefund(Long storeId, Long memberId, Integer value) { // 환불
        return PointHst.entityBuilder()
                .memberId(memberId)
                .storeId(storeId)
                .value(value)
                .status(PointStatus.REFUND)
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
