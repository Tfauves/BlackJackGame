package com.company.cardGame;

import com.company.actors.Player;

public class Hand {
    private Deck deck;
    private Player player;
    private int bet;
    private boolean isActiveTurn = true;



    public void hit(Deck deck) {
        System.out.println(deck.deal().display());

    }

    public void stand() {

    }

    public void doubleDown() {

    }

    public void split() {

    }

    public void getValue() {

    }

}
