package com.ahaPoint.point.schedular;

import com.ahaPoint.point.application.PointFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class PointScheduler {

    private PointFacade pointFacade;

    /**
     * 매일 자정 point의 만료시간을 체크합니다.
     */
    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void expiredPoint() {
        pointFacade.expirePoint();
        log.info("자정: 포인트 만료를 확인합니다.");
    }

}
