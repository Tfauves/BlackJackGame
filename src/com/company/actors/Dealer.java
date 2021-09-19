package com.company.actors;

public class Dealer implements Actor{
    private final String NAME = "dealer";
    private int balance = 0;
    private final int BET = 0;


    public String getName() {
        return NAME;
    }

    public int getBalance() {
        return balance;
    }

    public int getBet() {
        return BET;
    }

    public int getAction() {
        return 0;
    }
}
