package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst.AuthRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.authRequesst.AuthResponse;
import com.example.security_project_finally_jwt.security_project_finally.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/authentication")
@AllArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping
    @PermitAll
    public AuthResponse authResponse(@RequestBody AuthRequest authRequest){
        return authService.authenticate(authRequest);
    }
}
