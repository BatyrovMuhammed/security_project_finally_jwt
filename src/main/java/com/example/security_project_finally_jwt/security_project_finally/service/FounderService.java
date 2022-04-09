package com.example.security_project_finally_jwt.security_project_finally.service;

import com.example.security_project_finally_jwt.security_project_finally.dto.founder.FounderRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.founder.FounderResponse;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Founder;

public interface FounderService {

   // FounderResponse saveFounder(FounderRequest founderRequest);

    void saveFounder(Founder founder);

}
