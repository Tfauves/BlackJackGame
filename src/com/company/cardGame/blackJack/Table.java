package com.company.cardGame.blackJack;

import com.company.cardGame.actors.Dealer;
import com.company.cardGame.actors.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

import java.util.List;

public class Table {
     Hand player = new Hand(new Player("player"));
     Hand dealer = new Hand(new Dealer());
     Deck deck;

     public void playRound() {
         deck = new StandardDeck();
         deck.shuffle();
         deal();
//         displayTable();
        turn(player);
        turn(dealer);
         determineWinner();

     }

     private void deal() {
         for (int count = 0; count < 2; count++) {
             player.addCard(deck.draw());
             dealer.addCard(deck.draw());
         }
     }

    private void displayTable() {
         StringBuilder outPut = new StringBuilder();
         outPut.append("Dealer: ").append(dealer.displayHand()).append("\n");
         outPut.append("Player: ").append(player.displayHand());
        System.out.println(outPut);

    }

    private void determineWinner() {
         if (player.getValue() > dealer.getValue()) {
             System.out.println("Player Wins");
             return;
         }

         if (player.getValue() == dealer.getValue()) {
             System.out.println("Push");
             return;
         }
        System.out.println("Dealer Wins");
    }

    private void turn(Hand activeHand) {
        System.out.println("Dealer: " + dealer.displayHand());
        int action = activeHand.getAction();
        switch (action) {
            case 0 -> System.out.println("Quit");
            case 1 -> System.out.println("Hit");
            case 2 -> System.out.println("Stand");
            case 3 -> System.out.println("Double Down");
            case 4 -> System.out.println("Split");
            default -> System.out.println("ERROR bad action");
        }
    }

    private void hit(Hand activeHand) {
        // TODO: 9/27/2021 hit
    }

    private void stand(Hand activeHand) {
        // TODO: 9/27/2021 stand
    }

    private void doubleDown(Hand activeHand) {
        // TODO: 9/27/2021 doubleDown
    }

    private void split(Hand activeHand) {
        doubleDown(activeHand);
    }




}
