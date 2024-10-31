package com.baris.yirtinci.q5.service;

import com.baris.yirtinci.q5.model.Test;
import com.baris.yirtinci.q5.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestServiceTest {

    @Mock
    private TestRepository testRepository;

    @InjectMocks
    private TestService testService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @org.junit.jupiter.api.Test
    void testSave() {
        Test test = new Test();
        test.setName("John");
        test.setSurname("Doe");
        test.setPassword("password123");

        when(testRepository.save(test)).thenReturn(test);

        Test savedTest = testService.save(test);

        assertNotNull(savedTest);
        assertEquals("John", savedTest.getName());
        assertEquals("Doe", savedTest.getSurname());
    }

    @org.junit.jupiter.api.Test
    void testFindById() {
        Test test = new Test();
        test.setId(1L);
        test.setName("Jane");

        when(testRepository.findById(1L)).thenReturn(Optional.of(test));

        Optional<Test> foundTest = testService.findById(1L);

        assertTrue(foundTest.isPresent());
        assertEquals("Jane", foundTest.get().getName());
    }

    @org.junit.jupiter.api.Test
    void testFindAll() {
        when(testRepository.findAll()).thenReturn(List.of(new Test(), new Test()));

        List<Test> tests = testService.findAll();

        assertEquals(2, tests.size());
    }

    @org.junit.jupiter.api.Test
    void testDeleteById() {
        doNothing().when(testRepository).deleteById(1L);

        testService.deleteById(1L);

        verify(testRepository, times(1)).deleteById(1L);
    }
}