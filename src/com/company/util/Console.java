package com.company.util;

import com.company.actors.Player;
import com.company.cardGame.Deck;
import com.company.cardGame.Game;

import java.util.Scanner;

public class Console {
//    private Game blackJack;
    public final static Scanner scanner = new Scanner(System.in);
    public static final String[] ACTION_SELECTION = new String[] {
            "1. Hit",
            "2. Stand",
            "3. Split",
            "4. Double Down"
    };

    public static int getInt(int min, int max, String prompt, String errorMsg) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(errorMsg);
            }
        } while (option < min || option > max);
        return option;
    }

    public static void displayActions (String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static String getString(String prompt, boolean isRequired) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println("Entry Required");
                continue;
            }
            break;
        } while (true);
        return input;
    }


}
