package com.company.cardGame.deck;

public abstract class Card {
    private final String suit;
    private final int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return rank + " " + suit;
    }

    public abstract String display();


    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
