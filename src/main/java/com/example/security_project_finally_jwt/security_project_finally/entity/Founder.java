package com.example.security_project_finally_jwt.security_project_finally.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "founder")
@NoArgsConstructor
@Getter
@Setter
public class Founder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    @SequenceGenerator(name = "company_sequence", sequenceName = "company_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private String password;

    @OneToOne(cascade = ALL)
    private AuthInfo authInfo;

    public Founder(String firstName, String email, String lastName, AuthInfo authInfo) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.authInfo = authInfo;
    }


}
