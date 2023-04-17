package com.ahaPoint.point.infrastructure;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.point.domain.PointReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PointReaderImpl implements PointReader {

    private final PointRepository pointRepository;

    @Override
    public List<Point> findAbleToUsePoint(Long memberId) {
        return pointRepository.findAbleToUsePoint(memberId);
    }
}
