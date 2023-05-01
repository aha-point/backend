package com.ahaPoint.store.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetailInfoInput {

    private Long storeId; // store pk
    private List<PriceAndMenu> menus; // menu list
    private Boolean isReserve; // info-예약여부
    private Boolean isTakeOut; // info-포장여부
    private Boolean parking; // infra-주차
    private Boolean pet; // infra-반려견동반
    private Boolean playground; // infra-놀이방
    private Boolean wheelchair; // infra-휠체어
    private Boolean wifi; // infra-와이파이
    private StoreType storeType; // insert or update

}
