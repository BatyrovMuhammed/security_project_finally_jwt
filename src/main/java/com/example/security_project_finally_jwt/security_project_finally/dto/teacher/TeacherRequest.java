package com.example.security_project_finally_jwt.security_project_finally.dto.teacher;

import com.example.security_project_finally_jwt.security_project_finally.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequest {

    @NotNull
    private String firstName;

    private String email;

    private String password;

    private String lastName;

    @JsonIgnore
    private Course course;
}
