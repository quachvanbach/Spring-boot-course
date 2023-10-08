package com.example.spring.onetoonenunidirectional.dao;

import com.example.spring.onetoonenunidirectional.entity.Course;
import com.example.spring.onetoonenunidirectional.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {
    private EntityManager entityManager;

    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public List<Course> findCourseByTeacherId(int teacherId) {
//        Create query:
        TypedQuery<Course> query = entityManager.createQuery("from Course where teacher.id=:id", Course.class);
        query.setParameter("id", teacherId);

//        Excute query:
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "join fetch c.students " +
                        "where c.id=:id", Course.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
