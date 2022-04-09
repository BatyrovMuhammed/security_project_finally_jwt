package com.example.security_project_finally_jwt.security_project_finally.service;

import com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst.AuthRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);
}
