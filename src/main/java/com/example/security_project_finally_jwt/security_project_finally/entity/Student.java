package com.example.security_project_finally_jwt.security_project_finally.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private StudyFarmat studyFarmat;

    public Student(String firstName, String email, String lastName, StudyFarmat studyFarmat) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.studyFarmat = studyFarmat;
    }

    @ManyToOne(cascade = {MERGE, DETACH, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private Group group;

    @OneToOne(cascade = ALL, fetch = FetchType.EAGER)
    private AuthInfo authInfo;

    public void setStudyFormat(StudyFarmat studyFormat) {
        this.studyFarmat = studyFormat;
    }
}
