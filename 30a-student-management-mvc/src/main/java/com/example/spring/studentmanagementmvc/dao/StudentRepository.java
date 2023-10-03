package com.example.spring.studentmanagementmvc.dao;

import com.example.spring.studentmanagementmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Co the them phuong thuc khac
}
