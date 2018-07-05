package com.talan.kata;

import com.talan.kata.api.AccountController;
import com.talan.kata.core.AccountRepository;
import com.talan.kata.core.AccountService;
import com.talan.kata.spi.InMemeoryRepository;
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
        AccountRepository repository = new InMemeoryRepository();
        AccountService service = new AccountService(() -> UUID.randomUUID().toString(), repository);
        return new AccountController(service);
    }}
