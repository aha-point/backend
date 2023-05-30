package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointDto;
import com.ahaPoint.point.domain.PointReader;
import com.ahaPoint.store.infrastructure.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointReaderImpl implements PointReader {

    private final PointRepository pointRepository;

    private final PointHstRepository pointHstRepository;

    @Override
    public List<Point> findAbleToUsePoint(Long memberId) {
        return pointRepository.findAbleToUsePoint(memberId);
    }

    @Override
    public List<PointDto.PointDtoForMember> findPointListForMember(Long memberId) {
        List<PointDto.PointDtoForMember> list = pointHstRepository.findPointListForMember(memberId);
        return list.stream().map(dto -> PointDto.PointDtoForMember.getPointDto(dto)).toList();
    }

    @Override
    @Transactional
    public List<PointDto.PointDtoForStore> findPointListForStore(Long storeId) {
        return pointHstRepository.findPointListForStore(storeId);
    }



}
