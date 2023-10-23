package com.example.spring.account_ms.dao;

import com.example.spring.account_ms.entity.Gmail;
import com.example.spring.account_ms.entity.Phonenumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhonenumberRepository extends JpaRepository<Phonenumber, Integer> {
    @Query("select p from Phonenumber p where p.phonenumber=:phonenumber")
    public List<Phonenumber> findByPhonenumber(@Param("phonenumber") String phonenumber);
}
