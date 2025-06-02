package com.pluralsight.util;

import java.util.Scanner;

public class Menu {

    //declare a Scanner object for reading input from the console
    Scanner menuScanner = new Scanner(System.in);

    private int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = Integer.parseInt(menuScanner.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) { }
            System.out.println("⚠️  Enter a number between " + min + " and " + max);
        }
    }

    public int promptForDessert() {
        System.out.println("\n=========== 🍰 Available Desserts ===========");
        System.out.println("1) Flan");
        System.out.println("2) Churro");
        System.out.println("3) Tres Leches Cake");
        System.out.println("0) None");
        return readInt("Make a selection: ", 0, 3);
    }
}
