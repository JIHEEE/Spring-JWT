package com.oopsw.jh.service;

import java.util.Optional;

import com.oopsw.jh.dto.MemberDTO;

public interface LoginUseCase {
    Optional<MemberDTO> login(String id, String password);
}
