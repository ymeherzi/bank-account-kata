package com.talan.kata.infrastructure.rest;

import com.talan.kata.infrastructure.api.AccountService;
import io.javalin.Context;

public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    public void create(Context ctx) {
        Command command = ctx.bodyAsClass(Command.class);
        service.create(command.customer, command.currency);
        ctx.status(201).result("");
    }

}
