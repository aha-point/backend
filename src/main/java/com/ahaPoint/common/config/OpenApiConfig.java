package com.ahaPoint.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "aha point API 명세서",
                description = "aha point 프로젝트의 member api 명세서입니다.",
                version = "v1"
        )
)
@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .displayName("aha-point-project")
                .group("aha-point") // 프로젝트명
                .pathsToMatch("/api/*") // 해당 path는 다 매치한다.
                .build();
    }

}
