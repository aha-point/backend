package com.ahaPoint.store.domain;

import com.ahaPoint.point.domain.PointStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

public class StoreDto {

    @Data
    @AllArgsConstructor
    @Builder
    public static class Store {

        private Long storeId; // store pk
        private Long sysId; // sysUser의 pk
        private String storeName; // 상호명
        private String email; // 이메일
        private String storePhoneNumber; // 가게번호
        private String storeAddress; // 가게 주소
        private String storeZipCode; // 가게 우편번호
        private Long storeImageId; // 가게 이미지
        private Integer pointPercentage; // 포인트 퍼센트
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }
}
