package com.talan.kata.infrastructure.api;

import com.talan.kata.infrastructure.core.Account;
import com.talan.kata.infrastructure.spi.AccountRepository;

import java.util.function.Supplier;

public class AccountService {

    private final AccountRepository repository;
    private final Supplier<String> accountIdSupplier;

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
