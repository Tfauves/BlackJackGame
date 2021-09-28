package com.company.cardGame.blackJack;

import com.company.cardGame.actors.Dealer;
import com.company.cardGame.actors.Player;
import com.company.cardGame.deck.Deck;

import java.util.List;

public class Table {
     Hand player = new Hand(new Player("player"));
     Hand dealer = new Hand(new Dealer());
     Deck deck;

     public void playRound() {

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




}
