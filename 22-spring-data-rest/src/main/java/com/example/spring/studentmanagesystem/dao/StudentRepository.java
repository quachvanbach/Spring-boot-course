package com.example.spring.studentmanagesystem.dao;

import com.example.spring.studentmanagesystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "student")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
