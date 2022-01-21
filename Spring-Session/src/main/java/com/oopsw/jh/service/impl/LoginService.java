package com.oopsw.jh.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.oopsw.jh.core.Role;
import com.oopsw.jh.dto.MemberDTO;
import com.oopsw.jh.service.LoginUseCase;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    public Optional<MemberDTO> login(String email, String password) {

        //TODO: 로그인 연동

        //로그인 성공했다고 가정
        MemberDTO memberDTO = MemberDTO.builder()
                .userName("jihee")
                .email(email)
                .role(Role.USER)
                .build();

        return Optional.ofNullable(memberDTO);
        
    }
    
}