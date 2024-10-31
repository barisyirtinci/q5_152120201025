package com.baris.yirtinci.q5.controller;

import com.baris.yirtinci.q5.model.Test;
import com.baris.yirtinci.q5.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<Test> getAllTests() {
        return testService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        return testService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Test createTest(@RequestBody Test test) {
        return testService.save(test);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable Long id, @RequestBody Test test) {
        if (!testService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        test.setId(id);
        return ResponseEntity.ok(testService.save(test));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        if (!testService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        testService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}