package com.talan.kata.core;

import java.util.function.Supplier;

public class AccountService {

    private final AccountRepository repository;
    private Supplier<String> accountIdSupplier;

    public AccountService(Supplier<String> accountIdSupplier, AccountRepository repository) {
        this.accountIdSupplier = accountIdSupplier;
        this.repository = repository;
    }

    public void create(String customer, String currency) {
        String id = this.accountIdSupplier.get();
        Account account = new Account(id, customer, currency);
        this.repository.save(account);
    }
}
