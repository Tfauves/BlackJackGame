package com.company.cardGame.actors;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.util.Console;

public class Player implements Actor {
    private final String name;
    private int balance = 1000;
    public boolean isFirstRd = true;
    private int actionsCount;

    public Player (String name, int startBalance) {
        this.name = name;
        startBalance = startBalance;
    }

    public Player(String name) {
        this.name = name;
    }

    // TODO: 9/23/2021 add logic for double.
    // TODO: 9/23/2021 1. confirm first turn.
    // TODO: 9/23/2021 2. confirm player has enough funds.
    // TODO: 9/23/2021 add logic for split.
//        split can only be done if you can double and split must est for a pair.

    // TODO: 9/23/2021 3. add logic for split detect pair.

    private String getAvailableActions(Hand hand) {
        actionsCount = 2;
        StringBuilder outPut = new StringBuilder();
        outPut.append("0. Quit\n1. Hit\n2. Stand");
        if (hand.s) {
            outPut.append("0. Quit\n1. Hit\n2. Stand\n3. Double\n4. Split");
            isFirstRd = false;
            return outPut.toString();
        }
        outPut.append("0. Quit\n1. Hit\n2. Stand");
        return outPut.toString();

    }

    public int getAction(Hand hand) {
        System.out.println(hand.displayHand());
        System.out.println(hand.getValue());
        return Console.getInt(0,3, getAvailableActions(hand), "invalid selection");
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

}
