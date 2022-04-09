package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.student.StudentResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Student;
import com.example.security_project_finally_jwt.security_project_finally.service.GroupService;
import com.example.security_project_finally_jwt.security_project_finally.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/{id}")
public class StudentApi {

    private final StudentService studentService;
    private final GroupService groupService;

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @PostMapping("/save")
    public StudentResponse saveStudent(@PathVariable("id") Long id,
                                       @RequestBody StudentRequest studentRequest) {
        studentRequest.setGroupId(groupService.getByIdGroup(id));
        return studentService.saveStudent(id, studentRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @DeleteMapping("/delete/{deleteId}")
    public void deleteByStudent(@PathVariable("deleteId") Long id) {
        studentService.deleteByIdStudent(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping("/find/{findId}")
    public Optional<Student> findByIdStudent(@PathVariable("findId") Long id) {
        return studentService.findByIdStudent(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @PatchMapping("/update/{updateId}")
    public StudentResponse updateCourse(@PathVariable("updateId") Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

}
