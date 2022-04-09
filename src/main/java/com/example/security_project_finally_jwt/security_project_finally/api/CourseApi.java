package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Course;
import com.example.security_project_finally_jwt.security_project_finally.service.CompanyService;
import com.example.security_project_finally_jwt.security_project_finally.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course/{id}")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;
    private final CompanyService companyService;

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping
    public List<Course> findAllCourse() {
        return courseService.findAllCourse();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save")
    public CourseResponse saveCourse(@PathVariable("id") Long id, @RequestBody CourseRequest courseRequest) {
        courseRequest.setCompanyId(companyService.getByIdCompany(id));
        return courseService.saveCourse(id, courseRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{deleteId}")
    public void deleteByCourse(@PathVariable("deleteId") Long id) {
        courseService.deleteByIdCourse(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping("/courseId/{courseId}")
    public Course findByIdCourse(@PathVariable("courseId") Long id) {
        return courseService.findByIdCourse(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PatchMapping("/update/{updateId}")
    public CourseResponse updateCourse(@PathVariable("updateId") Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }
}
