package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
@Tag(name = "Course Controller", description = "CRUD operations for Courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Get All Courses", description = "Retrieve a list of all courses")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Operation(summary = "Create Course", description = "Create a new course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Course created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Course createCourse(
            @Parameter(description = "Course object to be created", required = true)
            @RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @Operation(summary = "Get Course by ID", description = "Retrieve a course by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved course"),
            @ApiResponse(responseCode = "404", description = "Course not found")
    })
    @GetMapping("/{id}")
    public Course getCourseById(
            @Parameter(description = "UUID of the course to retrieve", required = true)
            @PathVariable UUID id) {
        return courseService.getCourseById(id);
    }

    @Operation(summary = "Delete Course", description = "Delete a course by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Course deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Course not found")
    })
    @DeleteMapping("/{id}")
    public void deleteCourse(
            @Parameter(description = "UUID of the course to delete", required = true)
            @PathVariable UUID id) {
        courseService.deleteCourse(id);
    }
}
