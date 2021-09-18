package com.company;

import com.company.cardGame.CheatDeck;
import com.company.cardGame.Deck;
import com.company.cardGame.StandardDeck;

public class Main {

    public static void main(String[] args) {

        Deck cardDeck = new CheatDeck();
        cardDeck.shuffle();
        System.out.println(cardDeck.deal().display());
    }
}
