package com.example.security_project_finally_jwt.security_project_finally.repository;

import com.example.security_project_finally_jwt.security_project_finally.entity.AuthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthInfo, Long> {

    Optional<AuthInfo> findByEmail(String email);
}
