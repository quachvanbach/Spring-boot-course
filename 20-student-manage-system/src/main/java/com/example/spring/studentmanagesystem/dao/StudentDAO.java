package com.example.spring.studentmanagesystem.dao;

import com.example.spring.studentmanagesystem.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();
    public Student getById(int id);
    public Student save( Student student);
    public Student saveAndFlush(Student student);
    public void deleteById(int id);
}
