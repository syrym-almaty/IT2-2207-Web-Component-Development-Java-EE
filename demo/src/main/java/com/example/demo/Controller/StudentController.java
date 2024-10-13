package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Controller", description = "CRUD operations for Students")
@PreAuthorize("hasRole('STUDENT')")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Get All Students", description = "Retrieve a list of all students")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Create Student", description = "Create a new student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Student createStudent(
            @Parameter(description = "Student object to be created", required = true)
            @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @Operation(summary = "Get Student by ID", description = "Retrieve a student by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved student"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public Student getStudentById(
            @Parameter(description = "UUID of the student to retrieve", required = true)
            @PathVariable Long id) {
        return studentService.getStudentById(id);
    }
//labus
    @Operation(summary = "Delete Student", description = "Delete a student by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    public void deleteStudent(
            @Parameter(description = "UUID of the student to delete", required = true)
            @PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}