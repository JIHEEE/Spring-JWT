package com.oopsw.jh.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.oopsw.jh.core.Role;
import com.oopsw.jh.exception.CustomAuthenticationException;

import static com.oopsw.jh.core.SecurityConstants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>>>> preHandle");

        if (request.getSession().getAttribute(KEY_ROLE) != null && request.getSession().getAttribute(KEY_ROLE).equals(Role.USER.name())) {
            return true;
        } else {
            throw new CustomAuthenticationException();
        }
    }
    
}