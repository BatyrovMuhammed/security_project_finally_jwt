package com.example.security_project_finally_jwt.security_project_finally.repository;

import com.example.security_project_finally_jwt.security_project_finally.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Override
    List<Teacher> findAll();

    @Override
    <S extends Teacher> S save(S entity);

    @Override
    Optional<Teacher> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Query("select case when count(c) > 0 then true else false end" +
            " from Teacher c where c.authInfo.email = ?1")
    boolean existsByEmail(String email);
}
