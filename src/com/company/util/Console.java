package com.company.util;

import java.util.Scanner;

public class Console {
    public final static Scanner scanner = new Scanner(System.in);
    public static final String[] ACTION_SELECTION = new String[] {
            "1. Hit",
            "2. Stand",
            "3. Split",
            "4. Double"
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

    public static int getInt(int min, int max, String[] prompt, String errorMsg) {
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

    public static void displayActions() {

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
