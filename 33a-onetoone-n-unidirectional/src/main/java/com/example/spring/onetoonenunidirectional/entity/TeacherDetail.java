package com.example.spring.onetoonenunidirectional.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "identification_number")
    private String identificationNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "hobby")
    private String hobby;
    @Lob
    @Column(name = "avatar")
    private Blob avatar;

    public TeacherDetail(String identificationNumber, Date dateOfBirth, boolean gender, String phoneNumber, String address, double salary, String youtubeChannel, String facebook, String hobby, Blob avatar) {
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.youtubeChannel = youtubeChannel;
        this.facebook = facebook;
        this.hobby = hobby;
        this.avatar = avatar;
    }
}
