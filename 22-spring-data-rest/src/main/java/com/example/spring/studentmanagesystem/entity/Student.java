package com.example.spring.studentmanagesystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", length = 11)
    private int id;
    @Column (name = "last_name", length = 45)
    private String lastName;
    @Column (name = "first_name", length = 45)
    private String fistName;
    @Column (name = "email", length = 45)
    private String email;

    public Student(String lastName, String fistName, String email) {
        this.lastName = lastName;
        this.fistName = fistName;
        this.email = email;
    }
}
