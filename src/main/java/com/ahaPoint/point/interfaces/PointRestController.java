package com.ahaPoint.point.interfaces;

import com.ahaPoint.point.application.PointFacade;
import com.ahaPoint.point.domain.PointStatus;
import com.ahaPoint.point.interfaces.enums.ProcessType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PointRestController {

    private final PointFacade pointFacade;

    /**
     * 일반유저 - 현재 포인트 조회
     */
    @PostMapping("/point:getCurrentPoint")
    @Operation(summary = "현재 포인트", description = "일반 유저의 현재 포인트를 조회하는 api 입니다.")
    public Integer getCurrentPoint(String phoneNumber) {
        return pointFacade.getCurrentPoint(phoneNumber);
    }


    /**
     * 가게유저 - 포인트 적립/환불
     */
    @PostMapping("/point:updatePoint")
    @Operation(summary = "포인트를 적립/환불", description = "일반유저가 포인트를 적립 혹은 환불할때 포인트를 업데이트 합니다.")
    public Integer updatePoint(Long storeId, Long memberId, String processType, String point) {
        // 차감 후 포인트 보여진다.
        return null;
    }
}
