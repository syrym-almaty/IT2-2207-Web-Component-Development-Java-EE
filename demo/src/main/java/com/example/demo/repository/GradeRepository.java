package com.example.demo.repository;

import com.example.demo.entity.Grade;
import com.example.demo.entity.GradeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradeID> {
}
