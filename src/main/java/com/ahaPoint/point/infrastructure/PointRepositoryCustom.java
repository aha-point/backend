package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;

import java.util.List;

public interface PointRepositoryCustom {

    void updatePointComplete(Point point, Long storeId);

    void updatePointDivide(Point point);

}
