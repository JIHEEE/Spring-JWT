package com.oopsw.jh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oopsw.jh.provider.security.JwtAuthTokenProvider;

@Configuration
public class JwtConfiguration {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtAuthTokenProvider jwtProvider() {
        return new JwtAuthTokenProvider(secret);
    }
    
}