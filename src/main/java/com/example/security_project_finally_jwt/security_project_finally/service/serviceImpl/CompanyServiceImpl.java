package com.example.security_project_finally_jwt.security_project_finally.service.serviceImpl;

import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Company;
import com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper.CompanyEditMapper;
import com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper.CompanyViewMapper;
import com.example.security_project_finally_jwt.security_project_finally.repository.CompanyRepository;
import com.example.security_project_finally_jwt.security_project_finally.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyEditMapper companyEditMapper;
    private final CompanyViewMapper companyViewMapper;

    @Override
    public List<Company> findAllCompany() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        return companyViewMapper.viewCompany(
                companyRepository.save
                        (companyEditMapper.create(companyRequest)));
    }

    @Override
    public Company getByIdCompany(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public Optional<Company> findByIdCompany(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void deleteByIdCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).get();
        companyEditMapper.Update(company, companyRequest);
        return companyViewMapper.viewCompany(companyRepository.save(company));
    }
}
