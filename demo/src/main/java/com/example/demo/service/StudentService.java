package com.example.demo.service;
import com.example.demo.entity.Course;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.repository.GradeRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }
    public Student updateStudent(UUID id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    // Add other fields as necessary
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }
    @Autowired
    private GradeRepository gradeRepository;

    // Method to calculate GPA for a student
    public double calculateGPA(UUID studentId) {
        // Get all grades for the student from the Grade repository
        List<Grade> grades = gradeRepository.findByStudentId(studentId);

        // If there are no grades, return 0.0
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }

        // Calculate the total score from all grades
        double totalScore = grades.stream()
                .mapToDouble(Grade::getScore)
                .sum();

        // Return the average score as GPA
        return totalScore / grades.size();
    }

    // Method to update the student's GPA in the database
    @Transactional
    public void updateStudentGPA(UUID studentId) {
        double gpa = calculateGPA(studentId);

        // Fetch student from the repository and update the GPA
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        student.setGpa(gpa);

        studentRepository.save(student);
    }
}
