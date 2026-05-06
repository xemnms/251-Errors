package com.nepomuceno.backend.service;

import com.nepomuceno.backend.entity.Account;
import com.nepomuceno.backend.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public List<Account> getAll() { return repo.findAll(); }

    public Account getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found: " + id));
    }

    public Account create(Account account) {
        if (repo.existsByEmail(account.getEmail())) {
            throw new RuntimeException("Email already in use: " + account.getEmail());
        }
        return repo.save(account);
    }

    public Account update(Long id, Account updated) {
        Account existing = getById(id);
        existing.setUsername(updated.getUsername());
        existing.setEmail(updated.getEmail());
        existing.setPassword(updated.getPassword());
        existing.setRole(updated.getRole());
        return repo.save(existing);
    }

    public void delete(Long id) { repo.deleteById(id); }
}