package com.ahaPoint.common.config;

import com.ahaPoint.sysUser.application.SysUserFacade;
import com.ahaPoint.sysUser.domain.SysUserService;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final SysUserFacade sysUserFacade;
    @Value("${jwt.secret}")
    private String secretKey;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().requestMatchers("http://api.ahapoint.click:8080/**", "http://localhost:8080/**");
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors();
        http.httpBasic().disable(); // token으로 할거라 기본 방법 disable
        http.csrf().disable(); // 스프링 security는 기본적으로 csrf를 확인하기때문에 403에러 발생
        http.headers().frameOptions().sameOrigin(); // x-frame-options: SAMEORIGIN

        http
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll(); // 전체 허용 (임시)
                //.requestMatchers("/api/sysUser**").permitAll(); // 회원가입, 로그인은 전체허용
//                .requestMatchers(HttpMethod.POST, "/api/**").authenticated() // 그 외의 것들은 권한이 필요

        http.addFilterBefore(new JWTFilter(sysUserFacade, secretKey), UsernamePasswordAuthenticationFilter.class);
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/**").hasAnyRole()
//                        .anyRequest().authenticated()
//                );

        return http.build();
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://api.ahapoint.click:8080"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
