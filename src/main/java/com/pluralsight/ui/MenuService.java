package com.pluralsight.ui;

import java.util.Scanner;

public interface MenuService {
    // declare a Scanner object for reading input from the console
    Scanner menuScanner = new Scanner(System.in);

    // constructor:

    // showHomeScreen:
    //   - print app title and welcome message
    //   - print:
    //       1) New Order
    //       0) Exit
    //   - prompt user for choice
    //   - return user input

    // showOrderMenu:
    //   - print:
    //       1) Add Sandwich
    //       2) Add Drink
    //       3) Add Chips
    //       4) Checkout
    //       0) Cancel Order
    //   - prompt user for choice
    //   - return user input

    // promptForBreadType:
    //   - print list of bread types
    //   - ask user to type one in (e.g., "white")
    //   - return as user input

    // promptForSize:
    //   - ask user: "What size? (4, 8, or 12 inches)"
    //   - return user input

    // promptForToasted:
    //   - ask: "Would you like it toasted? (yes or no)"
    //   - return user input

    // promptForMeats:
    //   - possible loop (one or multiple meats?):
    //       - ask user to type of meat (or 'done' to finish)
    //       - ask if they want Extra meat? (yes or no)"
    //   - return list of meats and extras

    // and so on and so on........
}