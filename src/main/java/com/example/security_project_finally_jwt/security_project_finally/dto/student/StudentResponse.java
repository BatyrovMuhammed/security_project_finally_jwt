package com.example.security_project_finally_jwt.security_project_finally.dto.student;

import com.example.security_project_finally_jwt.security_project_finally.entity.StudyFarmat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private String id;

    private String firstName;

    private String email;

    private String lastName;

    private StudyFarmat studyFarmat;
}
