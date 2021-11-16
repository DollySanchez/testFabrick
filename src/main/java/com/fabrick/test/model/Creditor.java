package com.fabrick.test.model;

public class Creditor {
    private String name;
    private Account account;

    public Creditor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
