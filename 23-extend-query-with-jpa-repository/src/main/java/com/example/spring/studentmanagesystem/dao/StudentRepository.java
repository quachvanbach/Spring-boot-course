package com.example.spring.studentmanagesystem.dao;

import com.example.spring.studentmanagesystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Mở rộng truy vấn:
//    public List<Student> findByFirstName(String firstName);
//    public List<Student> findByFistNameAndLastName(String firstName, String lastName);
    public List<Student> findByFistNameNot(String firstName);

//    @Query("SELECT s from Student s where s.fistName<>?1")
//    public List<Student> findByFistNameNot(String firstName);
}
