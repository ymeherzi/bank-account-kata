package com.talan.kata.infrastructure.reopository;

import com.talan.kata.infrastructure.core.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryRepositoryTest {

    public InMemoryRepository repository = new InMemoryRepository();

    @Test
    public void should_save_account() {
        // Given
        Account account = new Account("001", "yassine.mehrzi", "eur");

        // When
        repository.save(account);

        //Then
        assertThat(repository.accounts.get("001")).isEqualTo(account);
    }

}