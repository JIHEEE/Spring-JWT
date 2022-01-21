package com.oopsw.jh.controller;

import lombok.RequiredArgsConstructor;
import lombok.var;

import org.springframework.web.bind.annotation.*;

import com.oopsw.jh.dto.LoginRequestDTO;
import com.oopsw.jh.exception.LoginFailedException;
import com.oopsw.jh.service.impl.LoginService;

import javax.servlet.http.HttpSession;

import static com.oopsw.jh.core.SecurityConstants.*;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public String login(HttpSession httpSession, @RequestBody LoginRequestDTO loginRequestDTO) {
    	
        var optionalMember = loginService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

        if(optionalMember.isPresent()) {
            httpSession.setAttribute(KEY_ROLE, optionalMember.get().getRole().name());
            httpSession.setAttribute("email", optionalMember.get().getEmail());
            httpSession.setMaxInactiveInterval(1800);
        } else {
            throw new LoginFailedException();
        }

        return "ok";
        
    }
    
}