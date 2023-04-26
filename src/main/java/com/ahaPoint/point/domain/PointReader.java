package com.ahaPoint.point.domain;

import java.util.List;

public interface PointReader {
    List<Point> findAbleToUsePoint(Long memberId);

    List<PointDto> findPointListForMember(Long memberId);

    List<PointDto> findPointListForStore(Long storeId);
}
