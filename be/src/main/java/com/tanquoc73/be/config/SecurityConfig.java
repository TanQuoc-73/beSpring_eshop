package com.tanquoc73.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/test/**").permitAll()  // Allow public access to test endpoints
                .requestMatchers("/api/brands/**").permitAll()  // Allow public access to brand endpoints
                .requestMatchers("/api/products/**").permitAll()  // Allow public access to product endpoints
                .requestMatchers("/api/product-variants/**").permitAll()  // Allow public access to product variant endpoints
                .anyRequest().authenticated()  // Require authentication for other endpoints
            );
            
        return http.build();
    }
}
