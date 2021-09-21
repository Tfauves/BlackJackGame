package com.company.util;

import java.util.Scanner;

public class Console {
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

    public void handleActionSelection(int choice) {
        switch (choice) {
            case 1 -> hit();
            case 2 -> stand();
            case 3 -> split();
            case 4 -> doubleDown();
            default -> System.out.println("invalid number received");
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
