package com.company.cardGame;

import com.company.util.Console;

public class Game {
    Table table;
    Hand hand;


    public void numbOfPlayers() {
        int numbOfPlayers = Console.getInt(1, 12, "enter number of players: ", "invalid entry");


    }

    public static int getInt(int min, int max, String prompt, String errorMsg) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = Console.scanner.nextLine();
            try{
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(errorMsg);
            }
        } while (option < min || option > max);
        return option;
    }



    public void getPlayerName() {
        System.out.println();


    }


}
