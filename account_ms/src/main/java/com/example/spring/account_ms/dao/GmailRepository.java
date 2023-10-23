package com.example.spring.account_ms.dao;

import com.example.spring.account_ms.entity.Gmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GmailRepository extends JpaRepository<Gmail, Integer> {
    @Query("select g from Gmail g where g.username=:username")
    public List<Gmail> findByUsername(@Param("username") String username);
}
