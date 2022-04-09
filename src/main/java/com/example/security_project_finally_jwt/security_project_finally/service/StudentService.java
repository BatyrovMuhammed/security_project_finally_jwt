package com.example.security_project_finally_jwt.security_project_finally.service;

import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudent();

    StudentResponse saveStudent(Long id, StudentRequest studentRequest);

    Optional<Student> findByIdStudent(Long id);

    Student getStudentById(Long id);

    void deleteByIdStudent(Long id);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);
}
