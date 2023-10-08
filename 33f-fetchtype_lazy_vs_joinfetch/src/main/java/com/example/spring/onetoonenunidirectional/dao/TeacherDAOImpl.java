package com.example.spring.onetoonenunidirectional.dao;

import com.example.spring.onetoonenunidirectional.entity.Course;
import com.example.spring.onetoonenunidirectional.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
    private EntityManager entityManager;

    @Autowired
    public TeacherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Teacher findTeacherById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void deleteTeacherById(int id) {
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.remove(teacher);
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
        entityManager.flush();
    }

    @Override
    public Teacher findTeacherByIdJoinFetch(int teacherId) {
        //        Create query:
        TypedQuery<Teacher> query = entityManager.createQuery(
                "select t from Teacher t " +
                        "JOIN FETCH t.teacherDetail " +
                        "JOIN FETCH t.courses " +
                        "where t.id=:id", Teacher.class);

        query.setParameter("id", teacherId);

//        Excute query:
        Teacher teacher = query.getSingleResult();

        return teacher;
    }
}