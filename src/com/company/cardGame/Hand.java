package com.company.cardGame;

import com.company.actors.Player;

public class Hand {
    private Deck deck;
    private Player player;
    private int bet;
    private boolean isActiveTurn = true;
    private int handValue;



    public Hand(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
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

    public Deck getDeck() {
        return deck;
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }
}
