package com.example.security_project_finally_jwt.security_project_finally.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    STUDENT,
    ADMIN,
    TEACHER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
