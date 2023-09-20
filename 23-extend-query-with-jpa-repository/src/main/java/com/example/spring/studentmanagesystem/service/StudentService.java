package com.example.spring.studentmanagesystem.service;

import com.example.spring.studentmanagesystem.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);
    public List<Student> getAllStudentsNotFirstName(String name);
    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

}
