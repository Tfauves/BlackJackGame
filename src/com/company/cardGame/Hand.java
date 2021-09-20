package com.company.cardGame;

import com.company.actors.Actor;
import com.company.actors.Player;

public class Hand {
    private Deck deck;
    private Actor player;
    private int bet;
    private boolean isActiveTurn = true;



    public Hand(Deck deck, Actor player) {
        this.deck = deck;
        this.player = player;
    }

    public void hit(Deck deck) {
        System.out.println(deck.deal().display());

    }

    public void stand() {

    }

    public void doubleDown() {

    }

    public void split() {

    }

    // TODO: 9/19/2021 sum hand for value.
    public void getValue() {

    }

}
