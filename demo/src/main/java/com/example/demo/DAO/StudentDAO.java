package com.example.demo.DAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    // Другие методы доступа к данным...
}
