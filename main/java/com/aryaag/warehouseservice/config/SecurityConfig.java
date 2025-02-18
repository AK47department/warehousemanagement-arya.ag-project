package com.aryaag.warehouseservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()               // Disable CSRF protection
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()   // Allow all requests without authentication
                )
                .httpBasic().disable()           // Disable basic auth
                .formLogin().disable();          // Disable form login
        return http.build();
    }
}
