package com.example.spring.account_ms.dao;

import com.example.spring.account_ms.entity.Role;
import com.example.spring.account_ms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRole(String name);

    @Query("select r.user from Role r where r.role=:role")
    public List<User> findAllByRole(@Param("role") String role);
}
