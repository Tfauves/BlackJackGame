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

        Actor player = new Player(Console.getString("enter player name", true));
        Hand myHand = new Hand(player);
        cardDeck.shuffle();
        myHand.addCard(cardDeck.deal());
        myHand.addCard(cardDeck.deal());

        myHand.setBet(myHand.getHolder().getBet());
        myHand.getHolder().setBalance(myHand.getHolder().getBalance() - myHand.betAmount());
        System.out.println(myHand.getHolder().getName() + "'s bet: " + myHand.betAmount() + " | Current balance: " + myHand.getHolder().getBalance());
//        goGame(player, myHand, cardDeck);

//        while (player.getAction(myHand) == Actor.HIT) {
//            myHand.addCard(cardDeck.deal());
//            System.out.println("HIT");
//        }
//        System.out.println("Done");

        while (player.getAction(myHand) == Actor.DOUBLE && player.getBalance() >= myHand.betAmount()) {
            myHand.addCard(cardDeck.deal());
            myHand.getHolder().setBalance(myHand.getHolder().getBalance() - myHand.betAmount());
            System.out.println(myHand.getHolder().getName() + "'s bet: " + myHand.betAmount() + " | Current balance: " + myHand.getHolder().getBalance());
            System.out.println("Double");

        }
        System.out.println("Done");

    }

//    public static void beginRound(Hand hand) {
////        boolean isFirstRound = true;
////         while(isFirstRound) {
//             hand.setBet(hand.getHolder().getBet());
//             hand.getHolder().setBalance(hand.getHolder().getBalance() - hand.betAmount());
//             System.out.println(hand.getHolder().getName() + "'s bet: " + hand.betAmount() + " | Current balance: " + hand.getHolder().getBalance());
//             hand.getHolder().getAction(hand);
////             isFirstRound = false;
////         }
//    }

    public static void goGame(Actor player, Hand myHand, Deck cardDeck) {
      switch (player.getAction(myHand)) {
          case 1:
              myHand.addCard(cardDeck.deal());
              break;
          case 2:
              System.out.println("Done");
              break;
          case 3:
              if ( player.getBalance() >= myHand.betAmount()) {
                myHand.addCard(cardDeck.deal());
                myHand.getHolder().setBalance(myHand.getHolder().getBalance() - myHand.betAmount());
                System.out.println(myHand.getHolder().getName() + "'s bet: " + myHand.betAmount() + " | Current balance: " + myHand.getHolder().getBalance());
                System.out.println("Double");
              }
              break;
          default:
        }
    }

    public static void doubleDown(Actor player, Hand myHand, Deck cardDeck) {
//        if (player.getAction(myHand) == Actor.DOUBLE && player.getBalance() >= myHand.betAmount()) {
            myHand.addCard(cardDeck.deal());
            myHand.getHolder().setBalance(myHand.getHolder().getBalance() - myHand.betAmount());
            System.out.println(myHand.getHolder().getName() + "'s bet: " + myHand.betAmount() + " | Current balance: " + myHand.getHolder().getBalance());
            System.out.println("Double");
//        }
        System.out.println("Done");
    }

    public static void hitIt(Actor player, Hand myHand, Deck cardDeck) {
        while (player.getAction(myHand) == Actor.HIT) {
            myHand.addCard(cardDeck.deal());
            System.out.println("HIT");
        }

        System.out.println("Done");

    }

}
