package com.oopsw.jh.dto;

import com.oopsw.jh.core.Role;

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
