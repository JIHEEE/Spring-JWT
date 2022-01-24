package com.oopsw.jh.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oopsw.jh.core.CommonResponse;
import com.oopsw.jh.core.service.dto.MemberDTO;
import com.oopsw.jh.exception.LoginFailedException;
import com.oopsw.jh.provider.security.JwtAuthToken;
import com.oopsw.jh.provider.service.LoginService;
import com.oopsw.jh.web.dto.LoginRequestDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public CommonResponse login(@RequestBody LoginRequestDTO loginRequestDTO) {

        Optional<MemberDTO> optionalMemberDTO = loginService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

        if (optionalMemberDTO.isPresent()) {

            JwtAuthToken jwtAuthToken = (JwtAuthToken) loginService.createAuthToken(optionalMemberDTO.get());

            return CommonResponse.builder()
                    .code("LOGIN_SUCCESS")
                    .status(200)
                    .message(jwtAuthToken.getToken())
                    .build();

        } else {
            throw new LoginFailedException();
        }
    }
    
}
