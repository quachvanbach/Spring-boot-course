package com.example.spring.account_ms.service;

import com.example.spring.account_ms.entity.ManagedAccount;

import java.util.List;

public interface ManagedAccountService {
    public List<ManagedAccount> getAll();

    public ManagedAccount getById(int id);

    public List<ManagedAccount> getByUsername(String username);

    public void save(ManagedAccount managedAccount);

    public void update(ManagedAccount managedAccount);

    public void deleteById(int id);
}
