package com.baris.yirtinci.q5.service;
import com.baris.yirtinci.q5.model.Test;
import com.baris.yirtinci.q5.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    public Test save(Test test) {
        return testRepository.save(test);
    }

    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }
}