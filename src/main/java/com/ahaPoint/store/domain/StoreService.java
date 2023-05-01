package com.ahaPoint.store.domain;

import com.ahaPoint.store.interfaces.StoreDetailInfoInput;

public interface StoreService {
    void saveStore(StoreCommand.Save save);

    void upsertStoreDetailInfo(StoreDetailInfoInput input);

}
