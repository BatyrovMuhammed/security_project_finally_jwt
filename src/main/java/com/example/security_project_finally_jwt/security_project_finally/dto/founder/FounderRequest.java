package com.example.security_project_finally_jwt.security_project_finally.dto.founder;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FounderRequest {

    @NotNull
    private String firstName;

    @Email
    private String email;

    private String password;

    @NotBlank
    private String lastName;

}
