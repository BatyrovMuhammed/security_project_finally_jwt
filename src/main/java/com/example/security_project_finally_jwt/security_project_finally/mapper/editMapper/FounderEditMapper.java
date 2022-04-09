package com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper;


import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.founder.FounderRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentRequest;
import com.example.security_project_finally_jwt.security_project_finally.entity.*;
import com.example.security_project_finally_jwt.security_project_finally.repository.GroupRepository;
import org.springframework.stereotype.Component;

@Component
public class FounderEditMapper {

    public Founder create(FounderRequest founderRequest) {
        if (founderRequest == null) {
            return null;
        }
        Founder founder = new Founder();
        founder.setFirstName(founderRequest.getFirstName());
        founder.setEmail(founderRequest.getEmail());
        founder.setLastName(founderRequest.getLastName());
        founder.setPassword(founderRequest.getPassword());

        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(founderRequest.getEmail());
        authInfo.setPassword(founderRequest.getPassword());
        authInfo.setRole(Role.ADMIN);

        founder.setAuthInfo(authInfo);
        return founder;
    }
}
