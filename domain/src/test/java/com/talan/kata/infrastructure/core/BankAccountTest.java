package com.talan.kata.infrastructure.core;

import com.talan.kata.infrastructure.api.AccountService;
import com.talan.kata.infrastructure.spi.AccountRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BankAccountTest {

    private AccountRepository repository;
    private AccountService service;

    @Before
    public void setup() {
        repository = mock(AccountRepository.class);
        service = new AccountService(() -> "0003", repository);
    }

    @Test
    public void should_create_account() {
        // Given
        Account expected = new Account("0003", "yassine.mehrzi", "eur");

        // When
        service.create("yassine.mehrzi", "eur");

        // Then
        verify(repository, times(1)).save(expected);
    }

}