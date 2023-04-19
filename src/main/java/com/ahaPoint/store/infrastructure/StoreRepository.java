package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
