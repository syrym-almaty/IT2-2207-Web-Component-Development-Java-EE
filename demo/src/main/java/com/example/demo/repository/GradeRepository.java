package com.example.demo.repository;

import com.example.demo.entity.Grade;
import com.example.demo.entity.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradeId> {
    Set<Grade> findByStudentId(Long studentId);
}
