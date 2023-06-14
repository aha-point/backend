package com.ahaPoint.point.domain;

import com.ahaPoint.member.domain.Member;
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
    @Column(name = "POINT_ID")
    private Long id; // point Pk

    @Column(name = "MEMBER_ID")
    private Long memberId; // member Id

    @NotNull
    private Double value; // 초기의 값

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PointStatus status; // point 상태

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* ============ <연관관계> ============ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", insertable = false, updatable = false)
    private Member member;

    public static Point toSave(Long memberId, Double value) {
        return Point.entityBuilder()
                .memberId(memberId)
                .value(value)
                .status(PointStatus.UNUSED)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Point toMakeCompletePoint(Long memberId, Double spendValue, LocalDateTime createdAt) {
        return Point.entityBuilder()
                .memberId(memberId)
                .value(spendValue)
                .status(PointStatus.COMPLETE)
                .createdAt(createdAt)
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
