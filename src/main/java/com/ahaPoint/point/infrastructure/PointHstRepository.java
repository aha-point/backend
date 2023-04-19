package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.PointHst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointHstRepository extends JpaRepository<PointHst, Long>, PointHstRepositoryCustom{
}
