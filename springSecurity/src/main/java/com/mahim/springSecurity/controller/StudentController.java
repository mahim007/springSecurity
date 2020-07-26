package com.mahim.springSecurity.controller;

import com.mahim.springSecurity.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private List<Student> students = Arrays.asList(
            new Student("mahim", "0"),
            new Student("nitol", "1"),
            new Student("ornob", "2")
    );

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return students
                .stream()
                .filter( student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("student with id: '" + id + "' not found"));
    }


}
