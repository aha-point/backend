package com.ahaPoint.point.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // point Pk
    private Long memberId; // member Id

    @NotNull
    private Double value; // 초기의 값

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PointStatus status; // point 상태

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Point toSave(Long memberId, Double value) {
        return Point.entityBuilder()
                .memberId(memberId)
                .value(value)
                .status(PointStatus.UNUSED)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Point toMakeCompletePoint(Point point, Double value) {
        return Point.entityBuilder()
                .memberId(point.getMemberId())
                .value(value)
                .status(PointStatus.COMPLETE)
                .createdAt(point.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }


    public static Point toMakeUnusedPoint(Point point, Double value) {
        return Point.entityBuilder()
                .memberId(point.getMemberId())
                .value(point.getValue() - value) // 사용한만큼 제하고 새롭게 저장한다.
                .status(PointStatus.UNUSED)
                .createdAt(point.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
