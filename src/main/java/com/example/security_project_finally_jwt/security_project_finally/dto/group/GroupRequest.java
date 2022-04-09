package com.example.security_project_finally_jwt.security_project_finally.dto.group;

import com.example.security_project_finally_jwt.security_project_finally.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequest {

    @NotNull
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;

    @JsonIgnore
    private Course courseId;

}
