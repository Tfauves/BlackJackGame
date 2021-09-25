package com.company;

import com.company.cardGame.actors.Player;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.cardGame.util.Console;


public class Main {

    public static void main(String[] args) {
        Deck cardDeck = new StandardDeck();
//        cardDeck.shuffle();
////        System.out.println(cardDeck.deal().display());
//        Hand playerHand = new Hand();
//        playerHand.hit(cardDeck);

//        Game blackJack = new Game();
//        blackJack.startGame();
//        Hand myHand = new Hand();
//        myHand.addCard(cardDeck.deal());
//        myHand.addCard(cardDeck.deal());
//        System.out.println(myHand.displayHand());
//        System.out.println(myHand.displayValue());

        Actor dealer = new Player(Console.getString("enter player name", true));
        Hand myHand = new Hand(dealer);
        cardDeck.shuffle();
        myHand.addCard(cardDeck.deal());
        myHand.addCard(cardDeck.deal());

        while (dealer.getAction(myHand) == Actor.HIT) {
            myHand.addCard(cardDeck.deal());
            System.out.println("HIT");
        }
        System.out.println("Done");
    }
}
