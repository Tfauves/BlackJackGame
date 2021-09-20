package com.company;

import com.company.cardGame.CheatDeck;
import com.company.cardGame.Deck;
import com.company.cardGame.Hand;
import com.company.cardGame.StandardDeck;

public class Main {

    public static void main(String[] args) {

        Deck cardDeck = new StandardDeck();
        cardDeck.shuffle();
//        System.out.println(cardDeck.deal().display());
        Hand playerHand = new Hand();
        playerHand.hit(cardDeck);
    }
}
