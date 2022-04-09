package com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String email;

    private String password;
}
