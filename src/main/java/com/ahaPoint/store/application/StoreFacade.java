package com.ahaPoint.store.application;

import com.ahaPoint.store.domain.StoreCommand;

//import com.ahaPoint.store.domain.StoreReader;
import com.ahaPoint.store.domain.StoreService;
import com.ahaPoint.store.interfaces.StoreDetailInfoInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreFacade {

    private final StoreService storeService;

//    private final StoreReader storeReader;


    public void saveStore (StoreCommand.Save save) {
        storeService.saveStore(save);
    }

    public void upsertStoreDetailedInfo(StoreDetailInfoInput input) {
        storeService.upsertStoreDetailInfo(input);
    }

}
