package com.example.demo.pattern;

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

    public void update(Student student) {
        entityManager.merge(student);
    }

    public void delete(Long id) {
        Student student = findById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}