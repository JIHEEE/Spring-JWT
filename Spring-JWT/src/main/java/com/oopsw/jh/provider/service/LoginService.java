package com.oopsw.jh.provider.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oopsw.jh.core.security.AuthToken;
import com.oopsw.jh.core.security.Role;
import com.oopsw.jh.core.service.LoginUseCase;
import com.oopsw.jh.core.service.dto.MemberDTO;
import com.oopsw.jh.provider.security.JwtAuthTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final static long LOGIN_RETENTION_MINUTES = 30;

    @Override
    public Optional<MemberDTO> login(String email, String password) {

        //TODO: 로그인 연동

        //로그인 성공했다고 가정하고..
        MemberDTO memberDTO = MemberDTO.builder()
                .userName("eddy")
                .email(email)
                .role(Role.USER)
                .build();

        return Optional.ofNullable(memberDTO);
    }

    //TODO: 네이밍
    @Override
    public AuthToken createAuthToken(MemberDTO memberDTO) {

        Date expiredDate = Date.from(LocalDateTime.now().plusMinutes(LOGIN_RETENTION_MINUTES).atZone(ZoneId.systemDefault()).toInstant());
        return jwtAuthTokenProvider.createAuthToken(memberDTO.getEmail(), memberDTO.getRole().getCode(), expiredDate);
    }
}