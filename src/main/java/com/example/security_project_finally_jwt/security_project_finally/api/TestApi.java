package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.entity.AuthInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test/auth")
public class TestApi {

    @GetMapping("/test")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'TEACHER')")
    public Map<String, String> test(Authentication authentication) {
        AuthInfo authInfo = (AuthInfo) authentication.getPrincipal();
        return Map.of(
                "email", authentication.getName(),
                "authority", authInfo.getRole().name()
        );
    }
}
