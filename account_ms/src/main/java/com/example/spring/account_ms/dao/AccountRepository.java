package com.example.spring.account_ms.dao;

import com.example.spring.account_ms.entity.ManagedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<ManagedAccount, Integer> {
    @Query("select ma from ManagedAccount ma where ma.accountType=:accountType")
    public List<ManagedAccount> findByAccountType(@Param("accountType") String accountType);

    @Query("select ma from ManagedAccount ma where ma.username=:username")
    public List<ManagedAccount> findByUsername(@Param("username") String username);

    @Query("select u from User u join fetch u.managedAccount where u.username=:username")
    public List<ManagedAccount> getAccountByUsername(@Param("username") String username);
}
