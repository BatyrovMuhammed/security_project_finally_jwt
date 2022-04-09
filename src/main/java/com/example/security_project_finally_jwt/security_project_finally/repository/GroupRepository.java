package com.example.security_project_finally_jwt.security_project_finally.repository;

import com.example.security_project_finally_jwt.security_project_finally.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    List<Group> findAll();

    @Override
    <S extends Group> S save(S entity);

    @Override
    Optional<Group> findById(Long aLong);

    @Override
    Group getById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
