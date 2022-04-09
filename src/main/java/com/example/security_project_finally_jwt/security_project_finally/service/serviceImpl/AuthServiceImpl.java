package com.example.security_project_finally_jwt.security_project_finally.service.serviceImpl;

import com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst.AuthRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst.AuthResponse;
import com.example.security_project_finally_jwt.security_project_finally.jwt.JwtUtils;
import com.example.security_project_finally_jwt.security_project_finally.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()));

        String generatedToken = jwtUtils.generateToken(authentication);

        return AuthResponse.builder()
                .email(authRequest.getEmail())
                .token(generatedToken)
                .build();
    }
}
