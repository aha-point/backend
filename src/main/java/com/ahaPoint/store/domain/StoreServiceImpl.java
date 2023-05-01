package com.ahaPoint.store.domain;

import com.ahaPoint.common.domain.ImageCommand;
import com.ahaPoint.store.infrastructure.StoreDtlInfoRepository;
import com.ahaPoint.store.infrastructure.StoreDtlInfraRepository;
import com.ahaPoint.store.infrastructure.StoreDtlMenuRepository;
import com.ahaPoint.store.infrastructure.StoreRepository;
import com.ahaPoint.store.interfaces.PriceAndMenu;
import com.ahaPoint.store.interfaces.StoreDetailInfoInput;
import com.ahaPoint.store.interfaces.StoreType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final StoreDtlMenuRepository storeDtlMenuRepository;
    private final StoreDtlInfoRepository storeDtlInfoRepository;
    private final StoreDtlInfraRepository storeDtlInfraRepository;

    @Override
    public void saveStore(StoreCommand.Save save) {
        storeRepository.save(StoreCommand.Save.toEntity(save));
    }

    @Override
    public void upsertStoreDetailInfo(StoreDetailInfoInput input) {
        // 1. 해당 store의 정보 확인
        Optional<Store> findStore = storeRepository.findById(input.getStoreId());
        if (findStore.isEmpty()) {
            throw new RuntimeException("해당 가게가 존재하지 않습니다.");
        }

        Long storeId = input.getStoreId();

        // 2. update 이면 기존 것은 삭제한다.
        if (StoreType.UPDATE == input.getStoreType()) {
            deletePreviousStoreDtl(storeId);
        }

        // 3. 새롭게 다시 insert 한다.
        if (StoreType.INSERT == input.getStoreType()) {
            List<PriceAndMenu> menus = input.getMenus();
            // 해당 메뉴 저장
            for (PriceAndMenu menu : menus) {
                StoreDtlMenu storeDtlMenu = StoreDtlCommand.Save.toEntity(menu, storeId);
                storeDtlMenuRepository.save(storeDtlMenu);
            }

            // 해당 info 저장.
            StoreDtlInfo storeDtlInfo = StoreDtlCommand.Save.toEntity(storeId, input.getIsReserve(), input.getIsTakeOut());
            storeDtlInfoRepository.save(storeDtlInfo);

            // 해당 infra 저장.
            StoreDtlInfra storeDtlInfra = StoreDtlCommand.Save.toEntity(storeId, input.getParking(), input.getPet(), input.getPlayground(), input.getWheelchair(), input.getWifi());
            storeDtlInfraRepository.save(storeDtlInfra);
        }


    }

    private void deletePreviousStoreDtl(Long storeId) {
        // 해당 menu 가져와서 삭제
        List<StoreDtlMenu> menusByStoreId = storeDtlMenuRepository.findByStoreId(storeId);
        for (StoreDtlMenu storeDtlMenu : menusByStoreId) {
            storeDtlMenuRepository.delete(storeDtlMenu);
        }

        // 해당 info 가져와서 삭제
        StoreDtlInfo storeInfo = storeDtlInfoRepository.findByStoreId(storeId);
        storeDtlInfoRepository.delete(storeInfo);

        // 해당 infra 가져와서 삭제
        StoreDtlInfra storeDtlInfra = storeDtlInfraRepository.findByStoreId(storeId);
        storeDtlInfraRepository.delete(storeDtlInfra);
    }
}
