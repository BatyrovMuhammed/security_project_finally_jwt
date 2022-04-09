package com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyRequest;
import com.example.security_project_finally_jwt.security_project_finally.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEditMapper {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void Update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
