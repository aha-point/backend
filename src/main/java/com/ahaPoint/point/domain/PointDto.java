package com.ahaPoint.point.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class PointDto {

    @Data
    @AllArgsConstructor
    @Builder
    public static class Point {

        private Long id; // point pk
        private String storeName; // 적립 - 적립한 가게명, 사용 - 사용한 가게명
        private Integer value; // 값
        private PointStatus pointStatus; // 사용, 적립, 환불
        private LocalDateTime createdAt; // 생성시간 - 적립이면 생성, 사용이면 수정
        private LocalDateTime updateAt;

    }
}
