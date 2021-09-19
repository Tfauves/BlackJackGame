package com.company.actors;

public class Player implements Actor{
    private final String name;
    private int balance;

    public Player (String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getBet() {
        return 0;
    }

    public void getAction() {}
}
