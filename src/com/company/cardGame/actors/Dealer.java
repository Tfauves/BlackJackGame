package com.company.cardGame.actors;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Dealer implements Actor {
    private final String NAME = "dealer";
    private int balance = 0;
    private final int BET = 0;

    // TODO: 9/19/2021 implement dealer 
    public String getName() {
        return NAME;
    }

    public int getBalance() {
        return balance;
    }

    public int getBet() {
        return BET;
    }

    public int getAction(Hand hand) {
        return 0;
    }

}
