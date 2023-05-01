package com.ahaPoint.store.interfaces;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StoreType {
    INSERT,
    UPDATE;
}
