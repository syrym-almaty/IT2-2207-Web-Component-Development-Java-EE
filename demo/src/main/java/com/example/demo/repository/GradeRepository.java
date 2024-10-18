package com.example.demo.repository;

import com.example.demo.entity.Grade;
import com.example.demo.entity.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, GradeId> {
    List<Grade> findByStudent_Id(Long studentId);
}
