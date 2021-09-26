package com.company.cardGame.actors;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.util.Console;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;

    public Player (String name, int startBalance) {
        this.name = name;
        startBalance = startBalance;
    }

    public Player(String name) {
        this.name = name;
    }


    private String getAvailableActions() {
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n2. Stand\n3. Double\n4. Split");
        return outPut.toString();
    }

    private String firstRoundActions() {
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n2. Stand\n3.");
        return outPut.toString();
    }

    public int getAction(Hand hand) {
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        return Console.getInt(0,4, getAvailableActions(), "invalid selection");
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBet() {
        return Console.getInt(1, balance, "Enter a bet between 1 - " + balance, "invalid bet");
    }


//    public String toString() {
//        return "| Player: " + name + " | Balance: " + balance + " |";
//    }
}
