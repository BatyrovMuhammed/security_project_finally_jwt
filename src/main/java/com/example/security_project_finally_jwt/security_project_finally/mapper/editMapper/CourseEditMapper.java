package com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseRequest;
import com.example.security_project_finally_jwt.security_project_finally.entity.Course;
import com.example.security_project_finally_jwt.security_project_finally.repository.CompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseEditMapper {

    private final CompanyRepository companyRepository;

    public CourseEditMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Course create(Long id, CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setCompany(companyRepository.findById(id).get());
        return course;
    }

    public void Update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
    }
}
