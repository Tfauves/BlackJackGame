package com.company.cardGame.blackJack;

import com.company.cardGame.actors.Dealer;
import com.company.cardGame.actors.Player;
import com.company.cardGame.util.Console;
import java.util.ArrayList;

public class Game {
    private Table table;
    private Hand hand;

//    public void startGame() {
//        table = new Table(new ArrayList(), new ArrayList(), new Dealer());
//        getPlayers();
////        table.displayTable();
//        getPlayerHand(table);
//    }

    // TODO: 9/19/2021 check into line 2
//    public void getPlayers() {
//        int numbOfPlayers = Console.getInt("enter number of players: ", 1, 12, "invalid entry");
//        for (int i = 0; i < numbOfPlayers; i++) {
//            String playerName = Console.getString("Enter Player Name: ", true);
//            Player player = new Player(playerName, 100);
//            table.getActors().add(player);
//        }
//
//    }

    public void getPlayerHand(Table table) {

//        for (Object player : table.getActors()) {
//            Hand hand = new Hand((Player) player, new StandardDeck());
//            hand.getDeck().shuffle();
//               Card card1 = hand.getDeck().deal();
//               Card card2 = hand.getDeck().deal();
//               hand.setHandValue(card1.getFaceValue() + card2.getFaceValue());
//
//            System.out.println(player.toString() + "Hand: " + card1.display() + " " + card2.display() + " | Hand Total: " + hand.getHandValue());
//            getAction((Player) player, hand);
//        }
    }

    public void getAction(Player activePlayer, Hand hand) {
        boolean isActive = true;
        while (isActive) {
            Console.displayActions("what would you like to do?", Console.ACTION_SELECTION);
            int choice = Console.getInt("Enter selection between 1 and 4:", 1, 4, "invalid selection");

            handleActionSelection(choice, hand);
        }

    }

    public void handleActionSelection(int choice, Hand hand) {
        switch (choice) {
            case 1 -> hit(hand);
            case 2 -> stand();
            case 3 -> split();
            case 4 -> doubleDown();
            default -> System.out.println("invalid number received");
        }
    }

    public void hit(Hand hand) {
//      Card newCard =  hand.getDeck().deal();
//        System.out.println(newCard);
//        hand.setHandValue(hand.getHandValue() + newCard.getFaceValue());
//      if (hand.getHandValue() > 21) {
//          System.out.println("Bust!!! " + hand.getHandValue());
//      } else {
//          hand.setHandValue(hand.getHandValue() + newCard.getFaceValue());
//          System.out.println(hand.getHandValue());
//      }
//      //next players turn
    }

    public void stand() {
        //nextPlayer turn


    }

    public void doubleDown() {
        //increase bet x2 and hit.

    }

    public void split() {

    }




}
