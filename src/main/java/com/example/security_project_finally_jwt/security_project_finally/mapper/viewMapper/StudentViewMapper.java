package com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        if (student.getId() != null) {
            studentResponse.setId(String.valueOf(student.getId()));
        }
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setStudyFarmat(student.getStudyFarmat());
        return studentResponse;

    }

    public List<StudentResponse> viewStudent(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student c : students
        ) {
            studentResponses.add(viewStudent(c));
        }
        return studentResponses;
    }
}
