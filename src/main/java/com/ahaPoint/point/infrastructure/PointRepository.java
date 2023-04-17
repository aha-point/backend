package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long>, PointRepositoryCustom {

}
