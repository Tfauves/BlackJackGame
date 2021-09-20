package com.company.cardGame;

import com.company.actors.Player;
import com.company.util.Console;

import java.util.ArrayList;

public class Game {
    private Table table;
    private Hand hand;

    public void startGame() {
        table = new Table(new ArrayList(), new ArrayList(), null);
        getPlayers();
        table.displayTable();
    }


    public void getPlayers() {
        int numbOfPlayers = Console.getInt(1, 12, "enter number of players: ", "invalid entry");
        for (int i = 0; i < numbOfPlayers; i++) {
            String playerName = Console.getString("Enter Player Name: ", true);
            Player player = new Player(playerName, 100);
            table.getActors().add(player);

        }

    }


}
