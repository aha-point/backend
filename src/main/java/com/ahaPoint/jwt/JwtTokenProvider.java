package com.ahaPoint.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private String secretKey = "ahapointpointaha";


}
