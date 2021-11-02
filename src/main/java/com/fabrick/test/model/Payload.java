package com.fabrick.test.model;

import java.util.Date;

public class Payload {
    public String date;
    public Float balance;
    public Float availableBalance;
    public String currency;

    public Payload() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }



}
