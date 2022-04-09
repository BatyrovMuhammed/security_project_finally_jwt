package com.example.security_project_finally_jwt.security_project_finally.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Data
public class Course {

    @SequenceGenerator(name = "course_sequence",
            sequenceName = "course_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH, REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "groups_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    @JsonIgnore
    private List<Group> gro = new ArrayList<>();

    @OneToOne(cascade = {MERGE, DETACH, REFRESH, REMOVE}, mappedBy = "course", fetch = FetchType.LAZY)
    @JsonIgnore
    private Teacher teacher;

    @ManyToOne(cascade = {MERGE, DETACH, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    public void setGroups1(Group group) {
        if (gro == null) {
            gro = new ArrayList<>();
        }
        gro.add(group);
    }
}
