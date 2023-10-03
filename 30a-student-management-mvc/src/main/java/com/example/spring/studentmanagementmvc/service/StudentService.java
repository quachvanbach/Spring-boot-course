package com.example.spring.studentmanagementmvc.service;

import com.example.spring.studentmanagementmvc.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudentById(int id);

}
