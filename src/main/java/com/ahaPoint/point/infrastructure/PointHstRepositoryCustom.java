package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointDto;

import java.util.List;

public interface PointHstRepositoryCustom {
    List<PointDto.PointDtoForMember> findPointListForMember(Long memberId);

    List<PointDto.PointDtoForStore> findPointListForStore(Long storeId);
}
