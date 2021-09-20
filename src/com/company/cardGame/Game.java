package com.company.cardGame;

import com.company.actors.Actor;
import com.company.actors.Dealer;
import com.company.actors.Player;
import com.company.util.Console;

import java.util.ArrayList;

public class Game {
    private Table table;
    private Hand hand;

    public void startGame() {
        table = new Table(new ArrayList(), new ArrayList(), new Dealer());
        getPlayers();
//        table.displayTable();
        getPlayerHand(table);
    }

    // TODO: 9/19/2021 check into line 2
    public void getPlayers() {
        int numbOfPlayers = Console.getInt(1, 12, "enter number of players: ", "invalid entry");
        for (int i = 0; i < numbOfPlayers; i++) {
            String playerName = Console.getString("Enter Player Name: ", true);
            Player player = new Player(playerName, 100);
            table.getActors().add(player);
        }

    }

    public void getPlayerHand(Table table) {

        for (Object player : table.getActors()) {
            hand = new Hand((Player) player, new StandardDeck());
            hand.getDeck().shuffle();
               Card card1 = hand.getDeck().deal();
               Card card2 = hand.getDeck().deal();
               int handValue = card1.getFaceValue() + card2.getFaceValue();
//                System.out.println(card1.display() + card2.display() + handValue);
//            table.getHands().add(hand);
            System.out.println(player.toString() + "Hand: " + card1.display() + card2.display() + " | Hand Total: " + handValue );
        }
    }


}
