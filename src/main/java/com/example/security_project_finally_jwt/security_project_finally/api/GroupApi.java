package com.example.security_project_finally_jwt.security_project_finally.api;

import com.example.security_project_finally_jwt.security_project_finally.dto.group.GroupRequest;
import com.example.security_project_finally_jwt.security_project_finally.dto.group.GroupResponse;
import com.example.security_project_finally_jwt.security_project_finally.entity.Group;
import com.example.security_project_finally_jwt.security_project_finally.service.CourseService;
import com.example.security_project_finally_jwt.security_project_finally.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group/{id}")
@RequiredArgsConstructor
public class GroupApi {

    private final GroupService groupService;
    private final CourseService courseService;

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping
    public List<Group> findAllGroup() {
        return groupService.findAllGroup();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/save")
    public GroupResponse saveGroup(@RequestBody GroupRequest groupRequest, @PathVariable("id") Long id) {
        groupRequest.setCourseId(courseService.getByIdCourse(id));
        return groupService.saveGroup(id, groupRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{deleteId}")
    public void deleteByGroup(@PathVariable("deleteId") Long id) {
        groupService.deleteByIdGroup(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    @GetMapping("/find/{findId}")
    public Optional<Group> findByIdGroup(@PathVariable("findId") Long id) {
        return groupService.findByIdGroup(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PatchMapping("/updateGroup/{updateId}")
    public GroupResponse updateGroup(@RequestBody GroupRequest groupRequest, @PathVariable("updateId") Long id) {
        return groupService.updateGroup(id, groupRequest);
    }

}
