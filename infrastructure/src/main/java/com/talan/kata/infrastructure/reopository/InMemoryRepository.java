package com.talan.kata.infrastructure.reopository;

import com.talan.kata.infrastructure.core.Account;
import com.talan.kata.infrastructure.spi.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements AccountRepository {

    public Map<String, Account> accounts = new HashMap<>();

    @Override
    public void save(Account expected) {
        accounts.put(expected.getId(), expected);
    }

}