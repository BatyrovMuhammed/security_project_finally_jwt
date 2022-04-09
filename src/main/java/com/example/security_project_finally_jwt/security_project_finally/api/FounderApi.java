package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.dto.founder.FounderRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.founder.FounderResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.AuthInfo;
import com.example.security_project_finally_jwt.security_project_finally.entity.Founder;
import com.example.security_project_finally_jwt.security_project_finally.entity.Role;
import com.example.security_project_finally_jwt.security_project_finally.service.FounderService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/founder/save")
@RequiredArgsConstructor
public class FounderApi {

    private final FounderService founderService;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void save(){
        Founder founder = new Founder();
        founder.setFirstName("Muhammed");
        founder.setEmail("muhammed@gmail.com");
        founder.setLastName("Batyrov");
        founder.setPassword(passwordEncoder.encode("2003"));
        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(founder.getEmail());
        authInfo.setPassword(founder.getPassword());
        authInfo.setRole(Role.ADMIN);
        founder.setAuthInfo(authInfo);
        founderService.saveFounder(founder);
    }
}
