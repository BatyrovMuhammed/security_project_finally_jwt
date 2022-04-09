package com.example.security_project_finally_jwt.security_project_finally.service;

import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> findAllTeacher();

    TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest);

    Optional<Teacher> findByIdTeacher(Long id);

    Teacher getTeacherById(Long id);

    void deleteByIdTeacher(Long id);

    TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest);
}
