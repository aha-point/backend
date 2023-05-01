package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.Store;
import com.ahaPoint.store.domain.StoreDtlInfo;
import com.ahaPoint.store.domain.StoreDtlMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreDtlInfoRepository extends JpaRepository<StoreDtlInfo, Long> {

    StoreDtlInfo findByStoreId(Long storeId);
}
