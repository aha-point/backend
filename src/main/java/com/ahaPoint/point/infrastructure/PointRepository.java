package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long>, PointRepositoryCustom {

    List<Point> findByMemberIdAndStatus(Long memberId, String status);

    List<Point> findByMemberIdAndStatusOrderByCreatedAt(Long memberId, String status);

    List<Point> findByMemberIdAndStatusAndSpendStoreIdAndUpdatedAt(Long memberId, String status, Long spendStoreId, LocalDateTime updateTime);
}
