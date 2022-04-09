package com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.course.CourseResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course){
        if(course==null){
            return null;
        }
        CourseResponse courseResponse=new CourseResponse();
        if(course.getId() != null){
            courseResponse.setId(String.valueOf(course.getId()));
        }
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;

    }

    public List<CourseResponse> viewCourses(List<Course> courses){
        List<CourseResponse>courseResponses=new ArrayList<>();
        for (Course c:courses
        ) {
            courseResponses.add(viewCourse(c));
        }
        return courseResponses;
    }
}
