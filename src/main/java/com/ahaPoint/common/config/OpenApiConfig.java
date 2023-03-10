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
                .group("aha-member") // 프로젝트명
                .pathsToMatch("/*") // 해당 path는 다 매치한다.
                .build();
    }

//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("aha project/member API")
//                        .description("aha point프로젝트의 Member API 명세서입니다.")
//                        .version("v0.0.1"));
//    }
}
