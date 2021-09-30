package com.company.cardGame.actors;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.util.Console;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;
    private int actionsCount;

    public Player (String name, int startBalance) {
        this.name = name;
        startBalance = startBalance;
    }

    public Player(String name) {
        this.name = name;
    }

    private String getAvailableActions(Hand hand) {
        actionsCount = 2;
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n2. Stand");
        if (hand.getSize() == 2 && balance >= hand.getBet()) {
            outPut.append("\n3. Double");
            actionsCount++;
            if (hand.canSplit()) {
                outPut.append("\n4. Split");
                actionsCount++;
            }
        }
        return outPut.toString();
    }

    public int getAction(Hand hand) {
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        return Console.getInt(getAvailableActions(hand), 0,actionsCount, "invalid selection");
    }


    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int placeBet() {
        int bet = Console.getInt("Enter a bet between 1 - " + balance, 1, balance, "invalid bet");
        balance -= bet;
        return bet;
    }

    public void addBalance(int amt) {
        balance += amt;
    }
}
