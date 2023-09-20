package com.example.spring.studentmanagesystem.service;

import com.example.spring.studentmanagesystem.dao.StudentRepository;
import com.example.spring.studentmanagesystem.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> getAllStudentsNotFirstName(String name) {
        return studentRepository.findByFistNameNot(name);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
