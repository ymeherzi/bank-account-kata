package com.talan.kata.infrastructure;

import com.talan.kata.infrastructure.api.AccountService;
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
        AccountService service = new AccountService(() -> UUID.randomUUID().toString(), repository);
        return new AccountController(service);
    }
}
