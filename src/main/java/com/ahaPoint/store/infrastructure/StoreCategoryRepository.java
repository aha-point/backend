package com.ahaPoint.store.infrastructure;

import com.ahaPoint.store.domain.StoreCategory;
import com.ahaPoint.store.domain.StoreDtlMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreCategoryRepository extends JpaRepository<StoreCategory, Long> {

}
