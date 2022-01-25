package com.oopsw.jh.provider.security;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.oopsw.jh.core.security.Role;
import com.oopsw.jh.exception.CustomAuthenticationException;
import com.oopsw.jh.provider.security.JwtAuthToken;
import com.oopsw.jh.provider.security.JwtAuthTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private static final String AUTHORIZATION_HEADER = "x-auth-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(">>>>>preHandle");

        Optional<String> token = resolveToken(request);

        if (token.isPresent()) {
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            if(jwtAuthToken.validate() & Role.USER.getCode().equals(jwtAuthToken.getData().get("role"))) { // 인증 , 인가
                return true;
            }
            else {
                throw new CustomAuthenticationException();
            }
        } else {
            throw new CustomAuthenticationException();
        }
        
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
    	
        String authToken = request.getHeader(AUTHORIZATION_HEADER);
        
        if (StringUtils.hasText(authToken)) {
            return Optional.of(authToken);
        } else {
            return Optional.empty();
        }
        
    }
    
}
