package com.nepomuceno.backend.controller;

import com.nepomuceno.backend.entity.Account;
import com.nepomuceno.backend.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:5173")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<Account> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Account getOne(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Account create(@RequestBody Account account) { return service.create(account); }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account account) {
        return service.update(id, account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}