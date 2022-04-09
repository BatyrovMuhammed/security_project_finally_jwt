package com.example.security_project_finally_jwt.security_project_finally.service;

import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {


    List<Company> findAllCompany();

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    Optional<Company> findByIdCompany(Long id);

    Company getByIdCompany(Long id);

    void deleteByIdCompany(Long id);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);
}
