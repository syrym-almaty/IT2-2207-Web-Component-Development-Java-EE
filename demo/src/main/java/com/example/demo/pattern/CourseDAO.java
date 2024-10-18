package com.example.demo.pattern;

import com.example.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void save(Course course) {
        entityManager.persist(course);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }

    public void delete(Long id) {
        Course course = findById(id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}