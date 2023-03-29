package com.ahaPoint.store.domain;

import com.ahaPoint.common.domain.ImageCommand;
import com.ahaPoint.store.infrastructure.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    @Override
    public void saveStore(StoreCommand.Save save) {
        storeRepository.save(StoreCommand.Save.toEntity(save));
    }
}
