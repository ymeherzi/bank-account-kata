package com.talan.kata.infrastructure;

import com.talan.kata.infrastructure.api.BankAccountImpl;
import com.talan.kata.infrastructure.api.BankAccount;
import com.talan.kata.infrastructure.reopository.InMemoryRepository;
import com.talan.kata.infrastructure.rest.AccountController;
import com.talan.kata.infrastructure.spi.AccountRepository;
import io.javalin.Javalin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Main {

    public static void main(String[] argv) {

        AccountController controller = factory();

        Javalin.start(7000)
                .post("/", controller::create);
    }

    @NotNull
    private static AccountController factory() {
        AccountRepository repository = new InMemoryRepository();
        BankAccount bankAccount = new BankAccountImpl(() -> UUID.randomUUID().toString(), repository);
        return new AccountController(bankAccount);
    }
}
