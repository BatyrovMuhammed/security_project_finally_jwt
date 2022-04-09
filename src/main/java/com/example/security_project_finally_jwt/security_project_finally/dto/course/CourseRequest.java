package com.example.security_project_finally_jwt.security_project_finally.dto.course;

import com.example.security_project_finally_jwt.security_project_finally.entity.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

    @NotNull
    private String courseName;

    private String duration;

    @JsonIgnore
    private Company companyId;
}
