package com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentRequest;
import com.example.security_project_finally_jwt.security_project_finally.entity.AuthInfo;
import com.example.security_project_finally_jwt.security_project_finally.entity.Role;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;
import com.example.security_project_finally_jwt.security_project_finally.repository.GroupRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentEditMapper {

    private final GroupRepository groupRepository;

    public StudentEditMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Student create(Long id, StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setEmail(studentRequest.getEmail());
        student.setLastName(studentRequest.getLastName());
        student.setStudyFarmat(studentRequest.getStudyFarmat());
        student.setGroup(groupRepository.getById(id));

        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(studentRequest.getEmail());
        authInfo.setPassword(studentRequest.getPassword());
        authInfo.setRole(Role.STUDENT);

        student.setAuthInfo(authInfo);
        return student;
    }

    public void Update(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());
        student.setEmail(studentRequest.getEmail());
        student.setLastName(studentRequest.getLastName());
        student.setStudyFormat(studentRequest.getStudyFarmat());
    }
}
