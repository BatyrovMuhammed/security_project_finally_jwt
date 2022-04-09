package com.example.security_project_finally_jwt.security_project_finally.service.serviceImpl;

import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;
import com.example.security_project_finally_jwt.security_project_finally.entity.Teacher;
import com.example.security_project_finally_jwt.security_project_finally.exception.BadRequestException;
import com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper.TeacherEditMapper;
import com.example.security_project_finally_jwt.security_project_finally.mapper.viewMapper.TeacherViewMapper;
import com.example.security_project_finally_jwt.security_project_finally.repository.TeacherRepository;
import com.example.security_project_finally_jwt.security_project_finally.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherResponse saveTeacher(Long id, TeacherRequest teacherRequest) {
        String email =teacherRequest.getEmail();
        boolean exists = teacherRepository.existsByEmail(email);

        if (exists){
            throw new BadRequestException(
                    String.format("teacher with email = %s has already exists", email)
            );
        }
        String encodedPassword = passwordEncoder.encode(teacherRequest.getPassword());
        teacherRequest.setPassword(encodedPassword);

        Teacher teacher = teacherEditMapper.create(id,teacherRequest);
        Teacher save = teacherRepository.save(teacher);

        return teacherViewMapper.viewTeacher(save);
    }
    @Override
    public Optional<Teacher> findByIdTeacher(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public void deleteByIdTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherEditMapper.Update(teacher, teacherRequest);
        return teacherViewMapper.viewTeacher(teacherRepository.save(teacher));
    }
}
