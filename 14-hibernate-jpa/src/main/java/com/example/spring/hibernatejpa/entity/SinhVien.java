package com.example.spring.hibernatejpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sinh_vien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ho_dem", length = 45)
    private String hoDem;
    @Column(name = "ten", length = 45, nullable = false)
    private String ten;
    @Column(name = "email")
    private String email;

    public SinhVien(String hoDem, String ten, String email) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }

}
