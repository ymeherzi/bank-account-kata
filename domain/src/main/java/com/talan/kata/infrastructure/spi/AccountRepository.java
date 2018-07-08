package com.talan.kata.infrastructure.spi;

import com.talan.kata.infrastructure.core.Account;

public interface AccountRepository {
    void save(Account expected);
}
