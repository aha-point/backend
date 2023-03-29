package com.ahaPoint.store.application;

import com.ahaPoint.member.domain.MemberCommand;
import com.ahaPoint.member.domain.MemberService;
import com.ahaPoint.store.domain.StoreCommand;
import com.ahaPoint.store.domain.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreFacade {

    private final StoreService storeService;


    public void saveStore (StoreCommand.Save save) {
        storeService.saveStore(save);
    }

}
