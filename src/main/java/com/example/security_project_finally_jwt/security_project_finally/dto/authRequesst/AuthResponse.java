package com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {

    private String email;

    private String token;

}
