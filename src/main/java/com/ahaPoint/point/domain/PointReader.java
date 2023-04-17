package com.ahaPoint.point.domain;

import java.util.List;

public interface PointReader {
    List<Point> findAbleToUsePoint(Long memberId);
}
