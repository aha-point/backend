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
    private Long storeId; // store Id

    @NotBlank
    private String value; // point 값
    private PointStatus status; // point 상태
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
