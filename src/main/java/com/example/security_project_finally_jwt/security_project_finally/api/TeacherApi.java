package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.teacher.TeacherResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Teacher;
import com.example.security_project_finally_jwt.security_project_finally.service.CourseService;
import com.example.security_project_finally_jwt.security_project_finally.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher/{id}")
@RequiredArgsConstructor
public class TeacherApi {

    private final TeacherService teacherService;
    private final CourseService courseService;

    // @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping
    @PermitAll
    public List<Teacher> findAllTeacher() {
        return teacherService.findAllTeacher();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @PostMapping("/save")
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest teacherRequest,
                                       @PathVariable("id") Long id) throws Exception {
        if (courseService.getByIdCourse(id).getTeacher() == null) {
            teacherRequest.setCourse(courseService.getByIdCourse(id));
        } else {
            throw new Exception();
        }
        return teacherService.saveTeacher(id, teacherRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @DeleteMapping("/delete/{deleteId}")
    public void deleteByTeacher(@PathVariable("deleteId") Long id) {
        teacherService.deleteByIdTeacher(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping("/find/{findId}")
    public Optional<Teacher> findByIdTeacher(@PathVariable("findId") Long id) {
        return teacherService.findByIdTeacher(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    @PatchMapping("/update/{updateId}")
    public TeacherResponse updateCourse(@PathVariable("updateId") Long id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }
}
