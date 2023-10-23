package com.example.spring.account_ms.dao;

import com.example.spring.account_ms.entity.ManagedAccount;
import com.example.spring.account_ms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    @Query("select u from User u join fetch u.managedAccount where u.username=:username")
    public List<ManagedAccount> getAccountByUsername(@Param("username") String username);
}
