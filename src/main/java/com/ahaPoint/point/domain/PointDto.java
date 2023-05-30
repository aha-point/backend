package com.ahaPoint.point.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PointDto {

        @Data
        @AllArgsConstructor
        @Builder
        public class PointDtoForMember {
        private Long id; // point hst pk
        private Long storeId; // store Id
        private String storeName; // 적립 - 적립한 가게명, 사용 - 사용한 가게명
        private Double value; // 값
        private PointStatus pointStatus; // 사용, 적립, 환불
        private LocalDateTime createdAt; // 생성시간 - 적립이면 생성, 사용이면 수정
        private LocalDateTime updateAt;

        public static PointDtoForMember getPointDto(PointDtoForMember dto) {
                return PointDtoForMember.builder()
                        .id(dto.getId())
                        .storeId(dto.getStoreId())
                        .storeName(dto.setPointStoreName(dto.getStoreId(), dto.getStoreName()) )
                        .value(dto.getValue())
                        .pointStatus(dto.getPointStatus())
                        .createdAt(dto.getCreatedAt())
                        .updateAt(dto.getUpdateAt())
                        .build();
        }

        private String setPointStoreName(Long storeId, String storeName) {
                if(storeId.equals(0L)) {
                        return "최초가입 포인트";
                }
                return storeName;
        }

        }

}
