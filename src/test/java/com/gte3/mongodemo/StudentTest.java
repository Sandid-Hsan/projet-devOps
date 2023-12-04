package com.gte3.mongodemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student("1", 12345, "John Doe", "john@example.com", 987654321);
        assertNotNull(student);
        assertEquals("1", student.getId());
        assertEquals(12345, student.getCIN());
        assertEquals("John Doe", student.getName());
        assertEquals("john@example.com", student.getEmail());
        assertEquals(987654321, student.getPhoneNumber());
    }

    // Add more test methods as needed
}
