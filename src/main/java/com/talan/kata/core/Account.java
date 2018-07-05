package com.talan.kata.core;

import java.util.Objects;

public class Account {

    private final String id;
    private final String customer;
    private final String currency;

    public Account(String id, String customer, String currency) {
        this.id = id;
        this.customer = customer;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(customer, account.customer) &&
                Objects.equals(currency, account.currency);
    }

    public String getId() {
        return this.id;
    }

}
