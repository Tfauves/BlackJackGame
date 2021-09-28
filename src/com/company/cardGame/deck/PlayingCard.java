package com.company.cardGame.deck;

public class PlayingCard extends Card {

    public PlayingCard(String suit, int faceValue) {
        super(suit, faceValue);
    }

    public String toString() {
        return getRank() + " " + getSuit();
    }

    @Override
    public String display() {
        String outPut = "";
        switch (getRank()) {
            case 1 -> outPut = "Ace";
            case 11 -> outPut = "Jack";
            case 12 -> outPut = "Queen";
            case 13 -> outPut = "King";
            default -> outPut = getRank() == 10 ? Integer.toString(getRank()) : " " + getRank();
        };
        return outPut + " " + getSuit();

    }

}
