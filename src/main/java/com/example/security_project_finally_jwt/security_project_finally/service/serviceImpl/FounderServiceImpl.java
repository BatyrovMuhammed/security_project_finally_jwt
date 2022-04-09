package com.example.security_project_finally_jwt.security_project_finally.service.serviceImpl;

import com.example.security_project_finally_jwt.security_project_finally.entity.Founder;
import com.example.security_project_finally_jwt.security_project_finally.repository.FounderRepository;
import com.example.security_project_finally_jwt.security_project_finally.service.FounderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FounderServiceImpl implements FounderService {

    private final FounderRepository founderRepository;

    @Override
    public void saveFounder(Founder founder) {
        founderRepository.save(founder);
    }


}

