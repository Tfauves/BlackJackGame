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
        table.displayTable();
        getPlayerHand(table);
    }

    // TODO: 9/19/2021 check into line 25
    public void getPlayers() {
        int numbOfPlayers = Console.getInt(1, 12, "enter number of players: ", "invalid entry");
        for (int i = 0; i < numbOfPlayers; i++) {
            String playerName = Console.getString("Enter Player Name: ", true);
            Player player = new Player(playerName, 100);
            table.getActors().add(player);
        }

    }

    // TODO: 9/19/2021 how do i get two cards dealt??
    public void getPlayerHand(Table table) {
        Deck cards = new StandardDeck();
        cards.shuffle();
        for (Object player : table.getActors()) {
            hand = new Hand(cards, (Player) player);
            System.out.println(player.toString() + "Hand: " + cards.deal().display());
        }
    }


}
