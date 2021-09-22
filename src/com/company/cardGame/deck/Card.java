package com.company.cardGame.deck;

public abstract class Card {
    private final String suit;
    private final int faceValue;

    public Card(String suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String toString() {
        return faceValue + " " + suit;
    }

    public abstract String display();


    public int getFaceValue() {
        return faceValue;
    }

    public String getSuit() {
        return suit;
    }
}
