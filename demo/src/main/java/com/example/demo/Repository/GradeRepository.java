package com.example.demo.Repository;

import com.example.demo.Entity.Grade;
import com.example.demo.Entity.GradeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradeID> {
    Set<Grade> findByStudentId(Long studentId);
}