package com.company;

import com.company.cardGame.*;

public class Main {

    public static void main(String[] args) {
//
//        Deck cardDeck = new StandardDeck();
//        cardDeck.shuffle();
////        System.out.println(cardDeck.deal().display());
//        Hand playerHand = new Hand();
//        playerHand.hit(cardDeck);

        Game blackJack = new Game();
        blackJack.getPlayers();
    }
}
