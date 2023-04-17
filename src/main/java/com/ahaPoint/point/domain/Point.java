package com.ahaPoint.point.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "point", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Point {

    @Id @GeneratedValue
    private Long id; // point Pk
    private Long memberId; // member Id
    private Long earnStoreId; // 적립한 store Id
    private Long spendStoreId; // 사용한 store Id


    @NotBlank
    private Integer value; // point 값
    @NotBlank
    private PointStatus status; // point 상태
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Point toSave(Long storeId, Long memberId, Integer value) {
        return Point.entityBuilder()
                .earnStoreId(storeId)
                .memberId(memberId)
                .value(value)
                .status(PointStatus.UNUSED)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Point toDivideComplete(Point point, Integer value, Long storeId) {
        return Point.entityBuilder()
                .memberId(point.getMemberId())
                .value(value)
                .earnStoreId(point.getEarnStoreId())
                .spendStoreId(storeId)
                .status(PointStatus.COMPLETE)
                .createdAt(point.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Point toDivideUnused(Point point, Integer value) {
        return Point.entityBuilder()
                .memberId(point.getMemberId())
                .value(value)
                .earnStoreId(point.getEarnStoreId())
                .status(PointStatus.UNUSED)
                .createdAt(point.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
