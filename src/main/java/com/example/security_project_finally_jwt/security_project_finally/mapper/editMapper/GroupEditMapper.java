package com.example.security_project_finally_jwt.security_project_finally.mapper.editMapper;

import com.example.security_project_finally_jwt.security_project_finally.dto.group.GroupRequest;
import com.example.security_project_finally_jwt.security_project_finally.entity.Group;
import com.example.security_project_finally_jwt.security_project_finally.repository.CourseRepository;
import org.springframework.stereotype.Component;

@Component
public class GroupEditMapper {

    public final CourseRepository courseRepository;

    public GroupEditMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Group create(Long id, GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;

        }
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        group.setCourse1(courseRepository.getById(id));
        return group;
    }

    public Group update(Group group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        return group;
    }
}
