package com.example.spring.onetoonenunidirectional;

import com.example.spring.onetoonenunidirectional.dao.StudentDAO;
import com.example.spring.onetoonenunidirectional.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "join fetch s.courses "
                        + "where s.id=:id", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
