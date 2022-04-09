package com.example.security_project_finally_jwt.security_project_finally.service;

import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourse();

    CourseResponse saveCourse(Long id, CourseRequest courseRequest);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    Course findByIdCourse(Long id);

    Course getByIdCourse(Long id);

    void deleteByIdCourse(Long id);


}
