package com.example.security_project_finally_jwt.security_project_finally.repository;

import com.example.security_project_finally_jwt.security_project_finally.entity.Founder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FounderRepository extends JpaRepository<Founder,Long> {

    @Override
    <S extends Founder> S save(S entity);

    @Query("select case when count(c) > 0 then true else false end" +
            " from Founder c where c.authInfo.email = ?1")
    boolean existsByEmail(String email);
}
