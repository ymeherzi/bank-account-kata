package com.talan.kata.infrastructure.rest;

import com.talan.kata.infrastructure.api.BankAccount;
import io.javalin.Context;

public class AccountController {

    private final BankAccount bankAccount;

    public AccountController(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void create(Context ctx) {
        Command command = ctx.bodyAsClass(Command.class);
        bankAccount.create(command.customer, command.currency);
        ctx.status(201).result("");
    }
}
