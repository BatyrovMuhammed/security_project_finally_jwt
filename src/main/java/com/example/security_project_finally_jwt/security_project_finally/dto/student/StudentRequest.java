package com.example.security_project_finally_jwt.security_project_finally.dto.student;

import com.example.security_project_finally_jwt.security_project_finally.entity.Group;
import com.example.security_project_finally_jwt.security_project_finally.entity.StudyFarmat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentRequest {

    @NotNull
    private String firstName;

    @Email
    private String email;

    private String password;

    @NotBlank
    private String lastName;

    private StudyFarmat studyFarmat;

    @JsonIgnore
    private Group groupId;
}
