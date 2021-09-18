package com.company.cardGame;

public class PlayingCard extends Card {

    public PlayingCard(String suit, int faceValue) {
        super(suit, faceValue);
    }

    public String toString() {
        return getFaceValue() + " " + getSuit();
    }

    public void display() {

    }

}
