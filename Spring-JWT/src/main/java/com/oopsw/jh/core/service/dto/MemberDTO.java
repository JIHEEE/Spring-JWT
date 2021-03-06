package com.oopsw.jh.core.service.dto;

import com.oopsw.jh.core.security.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDTO {

    private String id;
    private String userName;
    private String email;
    private Role role;
    
}
