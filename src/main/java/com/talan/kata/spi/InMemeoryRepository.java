package com.talan.kata.spi;


import com.talan.kata.core.Account;
import com.talan.kata.core.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemeoryRepository implements AccountRepository {

    public Map<String, Account> accounts = new HashMap<>();

    @Override
    public void save(Account expected) {
        accounts.put(expected.getId(), expected);
    }

}
