package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    // Other data access methods...
}
