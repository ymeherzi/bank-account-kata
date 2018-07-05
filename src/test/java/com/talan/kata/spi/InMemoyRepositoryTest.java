package com.talan.kata.spi;

import com.talan.kata.core.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoyRepositoryTest {

    public InMemeoryRepository repository = new InMemeoryRepository();

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
