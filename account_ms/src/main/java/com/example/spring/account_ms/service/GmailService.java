package com.example.spring.account_ms.service;

import com.example.spring.account_ms.entity.Gmail;
import com.example.spring.account_ms.entity.ManagedAccount;

import java.util.List;

public interface GmailService {
    public List<Gmail> getAll();

    public Gmail getById(int id);

    public List<Gmail> getByUsername(String username);

    public void save(Gmail gmail);

    public void update(Gmail gmail);

    public void deleteById(int id);
}
