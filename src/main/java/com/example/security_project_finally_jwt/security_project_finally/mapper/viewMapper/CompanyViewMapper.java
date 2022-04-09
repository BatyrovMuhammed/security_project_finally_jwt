package com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();
        if (company.getId() != null) {
            companyResponse.setId(String.valueOf(company.getId()));
        }
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        return companyResponse;

    }

    public List<CompanyResponse> viewCompanies(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company c : companies
        ) {
            companyResponses.add(viewCompany(c));
        }
        return companyResponses;
    }
}
