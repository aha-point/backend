package com.ahaPoint.point.interfaces;

import com.ahaPoint.point.application.PointFacade;
import com.ahaPoint.point.domain.PointDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

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
    public Double getCurrentPoint(String phoneNumber) {
        return pointFacade.getCurrentPoint(phoneNumber);
    }


    /**
     * 일반유저 - 포인트 적립/사용/환불 내역 조회
     */
    @PostMapping("/point:getPointListForMember")
    @Operation(summary = "포인트 내역 조회", description = "일반 유저의 포인트 사용/적립/환불 내역리스트 조회 api 입니다.")
    public List<PointDto> getPointListForMember(Long memberId) {
        return pointFacade.getPointListForMember(memberId);
    }


    /**
     * 가게유저 - 포인트 사용/적립
     */
    @PostMapping("/point:spendAndEarnPoint")
    @Operation(summary = "포인트를 적립/사용", description = "일반유저가 포인트를 적립 혹은 환불할때 포인트를 업데이트 합니다.")
    public Double spendAndEarnPoint(Long storeId, Long memberId, String processType, Double spendPoint, Double earnPoint) {
        return pointFacade.spendAndEarnPoint(storeId, memberId, processType, spendPoint, earnPoint);
    }

    /**
     * 일반 유저 - 포인트 환불
     */
    @PostMapping("/point:refundPoint")
    @Operation(summary = "포인트 환불", description = "일반유저가 포인트를 환불합니다.")
    public void refundPoint(Long memberId, Long storeId, LocalDateTime createdAt, Double refundPoint) {
        pointFacade.getRefundPoint(memberId, storeId, createdAt, refundPoint);
    }

}
