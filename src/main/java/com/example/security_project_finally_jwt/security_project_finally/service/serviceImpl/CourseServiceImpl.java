package com.example.security_project_finally_jwt.security_project_finally.service.serviceImpl;

import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Course;
import com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper.CourseEditMapper;
import com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper.CourseViewMapper;
import com.example.security_project_finally_jwt.security_project_finally.repository.CourseRepository;
import com.example.security_project_finally_jwt.security_project_finally.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseEditMapper courseEditMapper;
    private final CourseViewMapper courseViewMapper;

    @Override
    public List<Course> findAllCourse() {
        List<Course> course = courseRepository.findAll();
        return course;
    }

    @Override
    public CourseResponse saveCourse(Long id, CourseRequest courseRequest) {
        return courseViewMapper.viewCourse(courseRepository.save(courseEditMapper.create(id,courseRequest)));
    }

    @Override
    public Course findByIdCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(()-> new RuntimeException("not exists"+id));
    }

    @Override
    public Course getByIdCourse(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public void deleteByIdCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).get();
        courseEditMapper.Update(course, courseRequest);
        return courseViewMapper.viewCourse(courseRepository.save(course));
    }
}
