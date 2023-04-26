package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;

import java.time.LocalDateTime;
import java.util.List;

public interface PointRepositoryCustom {

    void updatePointComplete(Point point, Long storeId);

    void updateDividePointComplete(Point point, Double value);

    List<Point> findAbleToUsePoint(Long memberId);

    List<Point> findCompletePoint(Long memberId, LocalDateTime updatedAt);

    void updateRefundPoint(Long pointId);

}
