package com.example.spring.account_ms.service;

import com.example.spring.account_ms.dao.GmailRepository;
import com.example.spring.account_ms.entity.Gmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GmailServiceImpl implements GmailService {
    GmailRepository gmailRepository;

    @Autowired
    public GmailServiceImpl(GmailRepository gmailRepository) {
        this.gmailRepository = gmailRepository;
    }

    @Override
    public List<Gmail> getAll() {
        return gmailRepository.findAll();
    }

    @Override
    public Gmail getById(int id) {
        Optional<Gmail> gmailOptional = gmailRepository.findById(id);
        return gmailOptional.orElse(null);
    }

    @Override
    public List<Gmail> getByUsername(String username) {
        return gmailRepository.findByUsername(username);
    }

    @Override
    public void save(Gmail gmail) {
        gmailRepository.saveAndFlush(gmail);
    }

    @Override
    public void update(Gmail gmail) {
        gmailRepository.saveAndFlush(gmail);
    }

    @Override
    public void deleteById(int id) {
        gmailRepository.deleteById(id);
    }
}
