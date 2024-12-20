package com.flow.connect.configurations.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")  // Ensure it picks up all the paths in your app
                .packagesToScan("com.flow.connect.controllers")  // Scans controllers in the given package
                .build();
    }
}
