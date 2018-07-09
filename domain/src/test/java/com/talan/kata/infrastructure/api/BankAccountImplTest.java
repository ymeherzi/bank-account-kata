package com.talan.kata.infrastructure.api;

import com.talan.kata.infrastructure.core.Account;
import com.talan.kata.infrastructure.spi.AccountRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BankAccountImplTest {

    private AccountRepository repository;
    private BankAccount bankAccount;

    @Before
    public void setup() {
        repository = mock(AccountRepository.class);
        bankAccount = new BankAccountImpl(() -> "0003", repository);
    }

    @Test
    public void should_create_account() {
        // Given
        Account expected = new Account("0003", "yassine.mehrzi", "eur");

        // When
        bankAccount.create("yassine.mehrzi", "eur");

        // Then
        verify(repository, times(1)).save(expected);
    }

}