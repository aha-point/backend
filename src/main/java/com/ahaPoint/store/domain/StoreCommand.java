package com.ahaPoint.store.domain;

import com.ahaPoint.member.domain.Member;
import com.ahaPoint.member.domain.MemberCommand;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreCommand {

    /**
     * save 할때 dto
     */
    @Getter
    @ToString
    @Builder(toBuilder = true)
    public static class Save {

        private String storeName; // 상호명
        private String storePhoneNumber; // 가게번호
        private String storeAddress; // 가게 주소
        private String storeZipCode; // 가게 우편번호
        private Long storeImageId; // 가게 이미지
        private Integer pointPercentage; // 포인트 퍼센트
        private String email; // 이메일
        private Long sysUserId; // sys pk

    public static Store toEntity(StoreCommand.Save save) {
        return Store.entityBuilder()
                .sysId(save.getSysUserId())
                .storeName(save.getStoreName())
                .storePhoneNumber(save.getStorePhoneNumber())
                .storeAddress(save.getStoreAddress())
                .storeZipCode(save.getStoreZipCode())
                .storeImageId(save.getStoreImageId())
                .email(save.getEmail())
                .pointPercentage(save.getPointPercentage())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        }

    }

}
