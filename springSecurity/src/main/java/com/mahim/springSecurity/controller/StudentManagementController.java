package com.mahim.springSecurity.controller;

import com.mahim.springSecurity.dto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/management/api/students")
public class StudentManagementController {

    private List<Student> students = Arrays.asList(
            new Student("mahim", "0"),
            new Student("nitol", "1"),
            new Student("ornob", "2")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    public void registerStudents(@RequestBody Student student) {
        //students.add(student);
        System.out.println(student);
        System.out.println("students: " + students);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable String studentId, @RequestBody Student student) {
        System.out.println("student id: " + studentId + " student: " + student);
        Optional<Student> optionalStudent = students.stream()
                .filter(student1 -> student1.getId().equals(studentId))
                .findFirst();

        if (optionalStudent.isPresent()) {
            Student newStudent = optionalStudent.get();
            newStudent.setName(student.getName());
           // students.add(newStudent);
        } else {
            //students.add(student);
        }

        System.out.println(students);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable String studentId) {
        System.out.println("delete student with id: " + studentId);
        Optional<Student> optionalStudent = students.stream()
                .filter(student1 -> student1.getId().equals(studentId))
                .findFirst();

        if (optionalStudent.isPresent()) {
            Student newStudent = optionalStudent.get();
            //students.remove(newStudent);
        }
        System.out.println(students);
    }
}
