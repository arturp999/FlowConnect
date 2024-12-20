package com.flow.connect.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    String[] allowedUrls = {"/swagger-ui/**", "/v3/api-docs*/**"};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Apply permitAll to the list of URL patterns
        http.authorizeHttpRequests(authorizeRequests -> 
            authorizeRequests
                .requestMatchers(allowedUrls).permitAll()
                .anyRequest()
                .authenticated()  // deny all other requests
        );

        return http.build();
    }
}
