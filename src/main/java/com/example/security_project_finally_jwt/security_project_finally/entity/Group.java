package com.example.security_project_finally_jwt.security_project_finally.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @SequenceGenerator(name = "group_sequence",
            sequenceName = "group_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sequence")
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private String dateOfFinish;

    public Group(String groupName, String dateOfStart, String dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH}, fetch = FetchType.EAGER, mappedBy = "gro")
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @OneToMany(cascade = {PERSIST, MERGE, DETACH, REFRESH, REMOVE}, mappedBy = "group")
    @JsonIgnore
    private List<Student> students;

    @JsonIgnore
    public void setCourse1(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroups1(this);
    }

    public Course course2() {
        Course course = new Course();
        return course;
    }

}
