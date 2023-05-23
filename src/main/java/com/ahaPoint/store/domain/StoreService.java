package com.ahaPoint.store.domain;

import com.ahaPoint.store.interfaces.StoreDetailInfoInput;

import java.util.List;

public interface StoreService {
    Long saveStore(StoreCommand.Save save);

    void upsertStoreDetailInfo(StoreDetailInfoInput input);

    void upsertStoreCategory(Long storeId, List<String> categories);

}
