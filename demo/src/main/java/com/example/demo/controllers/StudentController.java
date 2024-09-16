package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create: Add a new student
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }

    // Read: Get all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    // Read: Get a specific student by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    // Update: Update a student by ID
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
        return "Student updated successfully!";
    }

    // Delete: Remove a student by ID
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
