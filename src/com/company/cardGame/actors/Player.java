package com.company.cardGame.actors;

import com.company.cardGame.blackJack.Actor;

public class Player implements Actor {
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

    public int getAction() {
        return 0;
    }

    public String toString() {
        return "| Player: " + name + " | Balance: " + balance + " |";
    }
}
