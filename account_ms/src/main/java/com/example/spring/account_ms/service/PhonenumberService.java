package com.example.spring.account_ms.service;

import com.example.spring.account_ms.entity.Phonenumber;

import java.util.List;

public interface PhonenumberService {
    public List<Phonenumber> getAll();

    public Phonenumber getById(int id);

    public List<Phonenumber> getByUsername(String phonenumber);

    public void save(Phonenumber phonenumber);

    public void update(Phonenumber phonenumber);

    public void deleteById(int id);
}
