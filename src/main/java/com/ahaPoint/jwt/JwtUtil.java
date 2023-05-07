package com.ahaPoint.jwt;

import com.ahaPoint.common.config.Jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // jwt는 claim이라고 해서 내가 원하는 정보를 토큰에 담아넣을수있음 ex) userName, id, password 등등
    public static String createToken(String phoneNumber, String secretKey, Long expiredMs) { // secret은 jwt의 서명에 넣을 예정
        Claims claims = Jwts.claims();
        claims.put("phoneNumber", phoneNumber);


        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(getSecretKey(secretKey), SignatureAlgorithm.HS256)
                .compact();
    }



    private static Key getSecretKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
