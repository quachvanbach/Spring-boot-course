package com.example.spring.account_ms.service;


import com.example.spring.account_ms.dao.PhonenumberRepository;
import com.example.spring.account_ms.entity.Phonenumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhonenumberServiceImpl implements PhonenumberService {
    PhonenumberRepository phonenumberRepository;

    @Autowired
    public PhonenumberServiceImpl(PhonenumberRepository phonenumberRepository) {
        this.phonenumberRepository = phonenumberRepository;
    }

    @Override
    public List<Phonenumber> getAll() {
        return phonenumberRepository.findAll();
    }

    @Override
    public Phonenumber getById(int id) {
        Optional<Phonenumber> phonenumberOptional = phonenumberRepository.findById(id);
        return phonenumberOptional.orElse(null);
    }

    @Override
    public List<Phonenumber> getByUsername(String username) {
        return phonenumberRepository.findByPhonenumber(username);
    }

    @Override
    public void save(Phonenumber phonenumber) {
        phonenumberRepository.saveAndFlush(phonenumber);
    }

    @Override
    public void update(Phonenumber phonenumber) {
        phonenumberRepository.saveAndFlush(phonenumber);
    }

    @Override
    public void deleteById(int id) {
        phonenumberRepository.deleteById(id);
    }
}
