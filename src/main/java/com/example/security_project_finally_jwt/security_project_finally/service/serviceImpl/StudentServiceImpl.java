package com.example.security_project_finally_jwt.security_project_finally.service.serviceImpl;

import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;
import com.example.security_project_finally_jwt.security_project_finally.exception.BadRequestException;
import com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper.StudentEditMapper;
import com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper.StudentViewMapper;
import com.example.security_project_finally_jwt.security_project_finally.repository.StudentRepository;
import com.example.security_project_finally_jwt.security_project_finally.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponse saveStudent(Long id, StudentRequest studentRequest) {
        studentRequest.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        return studentViewMapper.viewStudent(
                studentRepository.save(
                        studentEditMapper.create(id,studentRequest)));
    }

    @Override
    public Optional<Student> findByIdStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void deleteByIdStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).get();
        studentEditMapper.Update(student, studentRequest);
        return studentViewMapper.viewStudent(studentRepository.save(student));
    }
}
