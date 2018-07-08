package com.talan.kata.infrastructure.rest;

class Command {
    public String customer;
    public String currency;

    public Command() { }

    public Command(String customer, String currency) {
        this.customer = customer;
        this.currency = currency;
    }
}
