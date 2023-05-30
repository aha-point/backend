package com.ahaPoint.point.domain;

import java.util.List;

public interface PointReader {
    List<Point> findAbleToUsePoint(Long memberId);

    List<PointDto.PointDtoForMember> findPointListForMember(Long memberId);

    List<PointDto.PointDtoForStore> findPointListForStore(Long storeId);
}
