package com.company.actors;

public class Player implements Actor{
    private String name;
    private int balance;

    public Player (String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void getName() {}
    public void getBalance() {}
    public void getBet() {}
    public void getAction() {}
}
