package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.StoreDtlInfo;
import com.ahaPoint.store.domain.StoreDtlInfra;
import com.ahaPoint.store.domain.StoreDtlMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreDtlInfraRepository extends JpaRepository<StoreDtlInfra, Long> {

    StoreDtlInfra findByStoreId(Long storeId);
}
