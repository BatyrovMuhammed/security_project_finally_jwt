package com.example.security_project_finally_jwt.security_project_finally.dto.group;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  GroupResponse {

    private Long id;

    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;

}
