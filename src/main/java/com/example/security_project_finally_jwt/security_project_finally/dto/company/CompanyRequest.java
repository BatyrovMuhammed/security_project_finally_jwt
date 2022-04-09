package com.example.security_project_finally_jwt.security_project_finally.dto.company;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    private String companyName;

    private String locatedCountry;
}
