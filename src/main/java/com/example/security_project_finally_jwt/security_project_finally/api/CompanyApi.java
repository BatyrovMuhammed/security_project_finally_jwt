package com.example.security_project_finally_jwt.security_project_finally.api;

//Guava salyshtyruu dependency;

import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.company.CompanyResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Company;
import com.example.security_project_finally_jwt.security_project_finally.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping
    public List<Company> findAllCompany() {
        return companyService.findAllCompany();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save/company")
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteByCompany(@PathVariable Long id) {
        companyService.deleteByIdCompany(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping("/find/{id}")
    public Optional<Company> findByIdCompany(@PathVariable("id") Long id) {
        return companyService.findByIdCompany(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PatchMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable("id") Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

}
