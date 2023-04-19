package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;

import java.util.List;

public interface PointRepositoryCustom {

    void updatePointComplete(Point point, Long storeId);

    void updateDividePointComplete(Point point, Integer value);

    List<Point> findAbleToUsePoint(Long memberId);


}
