package com.example.spring.account_ms.service;

import com.example.spring.account_ms.dao.AccountRepository;
import com.example.spring.account_ms.entity.ManagedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagedManagedAccountImpl implements ManagedAccountService {
    AccountRepository accountRepository;

    @Autowired
    public ManagedManagedAccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<ManagedAccount> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public ManagedAccount getById(int id) {
        Optional<ManagedAccount> accountOptional = accountRepository.findById(id);
        return accountOptional.orElse(null);
    }

    @Override
    public List<ManagedAccount> getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public List<ManagedAccount> getByAccountType(String accountType) {
        return accountRepository.findByAccountType(accountType);
    }

    @Override
    public void save(ManagedAccount managedAccount) {
        accountRepository.saveAndFlush(managedAccount);
    }

    @Override
    public void update(ManagedAccount managedAccount) {
        accountRepository.saveAndFlush(managedAccount);
    }

    @Override
    public void deleteById(int id) {
        accountRepository.deleteById(id);
    }
}
