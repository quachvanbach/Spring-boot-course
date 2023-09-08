package com.example.spring.hibernatejpa.dao;

import com.example.spring.hibernatejpa.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);

    public SinhVien getById(int id);

    public List<SinhVien> getAll();

    public List<SinhVien> getByTen(String ten);

    public SinhVien update(SinhVien sinhVien);

    public int updateAllTen(String ten);

    public void deleteSinhVien(int id);
}
