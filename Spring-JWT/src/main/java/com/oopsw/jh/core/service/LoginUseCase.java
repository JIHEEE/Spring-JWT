package com.oopsw.jh.core.service;

import java.util.Optional;

import com.oopsw.jh.core.security.AuthToken;
import com.oopsw.jh.core.service.dto.MemberDTO;

public interface LoginUseCase {
    Optional<MemberDTO> login(String id, String password);
    AuthToken createAuthToken(MemberDTO memberDTO);
}
