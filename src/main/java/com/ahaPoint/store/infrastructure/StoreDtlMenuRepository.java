package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.StoreDtlInfra;
import com.ahaPoint.store.domain.StoreDtlMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreDtlMenuRepository extends JpaRepository<StoreDtlMenu, Long> {

    List<StoreDtlMenu> findByStoreId(Long storeId);
}
