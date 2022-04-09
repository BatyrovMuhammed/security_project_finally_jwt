package com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherRequest;
import com.example.security_project_finally_jwt.security_project_finally.entity.AuthInfo;
import com.example.security_project_finally_jwt.security_project_finally.entity.Role;
import com.example.security_project_finally_jwt.security_project_finally.entity.Teacher;
import com.example.security_project_finally_jwt.security_project_finally.repository.CourseRepository;
import org.springframework.stereotype.Component;

@Component
public class TeacherEditMapper {

    private final CourseRepository courseRepository;

    public TeacherEditMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Teacher create(Long id, TeacherRequest teacherRequest) {
        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setCourse(courseRepository.getById(id));

        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(teacherRequest.getEmail());
        authInfo.setPassword(teacherRequest.getPassword());
        authInfo.setRole(Role.TEACHER);

        teacher.setAuthInfo(authInfo);
        return teacher;
    }

    public void Update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setLastName(teacherRequest.getLastName());
    }

}
