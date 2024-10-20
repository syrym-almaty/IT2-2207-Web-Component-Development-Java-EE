package com.example.demo.entity;

import com.example.demo.validator.ValidCourseCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Course name is required")
    private String name;

    @NotBlank(message = "Course code is required")
    @Column(unique = true)
    @ValidCourseCode
    private String code;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    private int credits;
}