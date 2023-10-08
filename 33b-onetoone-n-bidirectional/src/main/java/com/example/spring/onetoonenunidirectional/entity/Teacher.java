package com.example.spring.onetoonenunidirectional.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name", length = 256)
    private String firstName;
    @Column(name = "last_name", length = 256)
    private String lastName;
    @Column(name = "email", length = 256)
    private String email;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_detail_id")
    private TeacherDetail teacherDetail;

    public Teacher(String firstName, String lastName, String email, TeacherDetail teacherDetail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teacherDetail = teacherDetail;
    }
}
