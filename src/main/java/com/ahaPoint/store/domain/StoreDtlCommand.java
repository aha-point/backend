package com.ahaPoint.store.domain;

import com.ahaPoint.store.interfaces.PriceAndMenu;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoreDtlCommand {

    /**
     * save 할때 dto
     */
    @Getter
    @ToString
    @Builder(toBuilder = true)
    public static class Save {

        private Long storeId; // 가게 pk
        private String menu; // 메뉴
        private Long price; // 가격
    public static StoreDtlMenu toEntity(PriceAndMenu menus, Long storeId) {
        return StoreDtlMenu.entityBuilder()
                .storeId(storeId)
                .menu(menus.getMenu())
                .price(menus.getPrice())
                .build();
        }

    public static StoreDtlInfo toEntity(Long storeId, Boolean isReserve, Boolean isTakeOut) {
        return StoreDtlInfo.entityBuilder()
                .storeId(storeId)
                .isReserve(CommonYn.toYn(isReserve))
                .isReserve(CommonYn.toYn(isTakeOut))
                .build();

    }

        public static StoreDtlInfra toEntity(Long storeId, Boolean parking, Boolean pet, Boolean playground, Boolean wheelchair, Boolean wifi) {
            return StoreDtlInfra.entityBuilder()
                    .storeId(storeId)
                    .parking(CommonYn.toYn(parking))
                    .pet(CommonYn.toYn(pet))
                    .playground(CommonYn.toYn(playground))
                    .wheelchair(CommonYn.toYn(wheelchair))
                    .wifi(CommonYn.toYn(wifi))
                    .build();

        }
    }

}
