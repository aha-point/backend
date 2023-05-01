package com.ahaPoint.store.interfaces;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class PriceAndMenu {
    private String menu;
    private Integer price;
}
