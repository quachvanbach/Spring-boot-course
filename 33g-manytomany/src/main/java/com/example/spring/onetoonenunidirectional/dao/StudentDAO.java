package com.example.spring.onetoonenunidirectional.dao;

import com.example.spring.onetoonenunidirectional.entity.Student;

public interface StudentDAO {
    public void save(Student student);

    public Student findStudentById(int id);

    public Student findStudentAndCourseByStudentId(int id);
}
