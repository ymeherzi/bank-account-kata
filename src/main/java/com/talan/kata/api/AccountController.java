package com.talan.kata.api;

import com.talan.kata.core.AccountService;
import io.javalin.Context;

public class AccountController {


    private AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    public void create(Context ctx) {
        Command command = ctx.bodyAsClass(Command.class);
        service.create(command.customer, command.currency);
        ctx.status(201).result("");
    }

}
