package com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.founder.FounderResponse;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Founder;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class FounderViewMapper {

    public FounderResponse  viewFounder(Founder founder) {
        if (founder == null) {
            return null;
        }
        FounderResponse founderResponse = new FounderResponse();
        if (founder.getId() != null) {
            founderResponse.setId(String.valueOf(founder.getId()));
        }
        founderResponse.setFirstName(founder.getFirstName());
        founderResponse.setEmail(founder.getEmail());
        founderResponse.setLastName(founder.getLastName());
        return founderResponse;

    }
}
