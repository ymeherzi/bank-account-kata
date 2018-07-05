package com.talan.kata.core;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BankAccountTest {

    AccountRepository repository = Mockito.mock(AccountRepository.class);
    private AccountService service;

    @Before
    public void setup() {
        service = new AccountService(() -> "0003", repository);
    }

    @Test
    public void should_create_account() {
        Account expected = new Account("0003", "yassine.mehrzi", "eur");
        service.create("yassine.mehrzi", "eur");
        verify(repository, times(1)).save(expected);
    }


}