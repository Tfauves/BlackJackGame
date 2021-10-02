package com.company.cardGame.actors;

import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;

public class Dealer implements Actor {
    public int STAND_VALUE = 17;

    public String getName() {
        return "DEALER";
    }

    public int getBalance() {
        return 0;
    }

    @Override
    public int placeBet() {
        return 0;
    }

    public void addBalance(double amt) {
        return;
    }

    public int getAction(Hand hand) {
        return hand.getValue() < STAND_VALUE ? HIT : STAND;
    }


}
