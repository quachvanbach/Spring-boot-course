package com.example.spring.hibernatejpa.dao;

import com.example.spring.hibernatejpa.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Đánh dấu đây là nơi thao tác với dữ liệu
@Transactional
public class SinhVienDAOImpl implements SinhVienDAO {
    private EntityManager entityManager;

    @Autowired
    public SinhVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.entityManager.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int id) {
        return this.entityManager.find(SinhVien.class, id);
    }

    @Override
    public List<SinhVien> getAll() {
        String jpql = "SELECT s FROM SinhVien s";
        List<SinhVien> sinhVienList = this.entityManager.createQuery(jpql, SinhVien.class).getResultList();
        return sinhVienList;
    }

    @Override
    public List<SinhVien> getByTen(String ten) {
        String jpql = "SELECT s FROM SinhVien s WHERE s.ten = :t";
        TypedQuery<SinhVien> query = this.entityManager.createQuery(jpql, SinhVien.class);
        query.setParameter("t", ten);
        return query.getResultList();
    }

    @Override
    public SinhVien update(SinhVien sinhVien) {
        return this.entityManager.merge(sinhVien);
    }

    @Override
    public int updateAllTen(String ten) {
        String jpql = "UPDATE SinhVien s SET s.ten=:t";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("t", ten);
        return query.executeUpdate();
    }

    @Override
    public void deleteSinhVien(int id) {
        SinhVien sinhVien = this.entityManager.find(SinhVien.class, id);
        this.entityManager.remove(sinhVien);
    }
}
