package com.ahaPoint.point.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hstId; // point Pk
    private Long memberId; // member Id
    private Long storeId; // 적립 혹은 사용한 store
    @NotNull
    private Double value; // point 값
    @Enumerated(value = EnumType.STRING)
    private PointStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PointHst toSave(Long storeId, Long memberId, Double value) { // 적립
        return PointHst.entityBuilder()
                .memberId(memberId)
                .storeId(storeId)
                .value(value)
                .status(PointStatus.UNUSED)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static PointHst toSpend(Long storeId, Long memberId, Double value) { // 사용
        return PointHst.entityBuilder()
                .memberId(memberId)
                .storeId(storeId)
                .value(value)
                .status(PointStatus.COMPLETE)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static PointHst toRefund(Long storeId, Long memberId, Double value) { // 환불
        return PointHst.entityBuilder()
                .memberId(memberId)
                .storeId(storeId)
                .value(value)
                .status(PointStatus.REFUND)
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
