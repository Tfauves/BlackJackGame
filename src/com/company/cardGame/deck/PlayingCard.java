package com.company.cardGame.deck;

import com.company.cardGame.deck.Card;

public class PlayingCard extends Card {

    public PlayingCard(String suit, int faceValue) {
        super(suit, faceValue);
    }

    public String toString() {
        return getFaceValue() + " " + getSuit();
    }

    public String display() {
        String outPut = "";
        switch (getFaceValue()) {
            case 1 -> outPut = "Ace";
            case 11 -> outPut = "Jack";
            case 12 -> outPut = "Queen";
            case 13 -> outPut = "King";
            default -> outPut = getFaceValue() == 10 ? Integer.toString(getFaceValue()) : " " + getFaceValue();
        };
        return outPut + " " + getSuit();

    }

}
