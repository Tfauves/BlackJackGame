package com.company;

import com.company.cardGame.actors.Player;
import com.company.cardGame.blackJack.Actor;
import com.company.cardGame.blackJack.Hand;
import com.company.cardGame.deck.Card;
import com.company.cardGame.deck.CheatDeck;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;
import com.company.cardGame.util.Console;


public class Main {

    public static void main(String[] args) {
        Deck cardDeck = new CheatDeck();

        Actor player = new Player(Console.getString("enter player name", true));
        Hand myHand = new Hand(player);
        cardDeck.shuffle();
        myHand.addCard(cardDeck.deal());
        myHand.addCard(cardDeck.deal());

        myHand.setBet(myHand.getHolder().getBet());
        myHand.getHolder().setBalance(myHand.getHolder().getBalance() - myHand.betAmount());
        System.out.println(myHand.getHolder().getName() +
                "'s bet: " + myHand.betAmount() +
                " | Current balance: " + myHand.getHolder().getBalance()
        );

//        while (player.getAction(myHand) == Actor.HIT) {
//            myHand.addCard(cardDeck.deal());
//            System.out.println("HIT");
//        }
//        System.out.println("Done");

//        while (player.getAction(myHand) == Actor.DOUBLE && player.getBalance() >= myHand.betAmount()) {
//            myHand.addCard(cardDeck.deal());
//            myHand.getHolder().setBalance(myHand.getHolder().getBalance() - myHand.betAmount());
//            System.out.println(myHand.getHolder().getName() +
//            "'s bet: " + myHand.betAmount() +
//            " | Current balance: " + myHand.getHolder().getBalance()
//            );
//            System.out.println("Double");
//        }
//        System.out.println("Done");

//        while (player.getAction(myHand) == Actor.SPLIT && player.getBalance() >= myHand.betAmount()) {
//            myHand.checkPair();
//        }

        myHand.checkPair();


    }
}

