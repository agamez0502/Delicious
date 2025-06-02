package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.MenuService;
import com.pluralsight.util.ReceiptWriter;

public class UserInterface {

    private MenuService menuService = new MenuService();

    //method that will run in main method and bring everything to life
    public void run() {

        //welcome message for user
        menuService.displayWelcomeScreen();

        //while loop will run until user chooses to exit the application
        boolean appRunning = true;

        while (appRunning) {

            //display home screen options
            printSlowly();
            int choice = menuService.showHomeScreen();

            //switch statement based on choice
            switch (choice) {

                //new order
                case 1 -> startOrder();

                //exit
                case 0 -> {
                    appRunning = false;
                    menuService.displayExitScreen();
                }

                default -> System.out.println("⚠️ Invalid selection. Please try again.");
            }
        }
    }

    //method for starting a new order
    private void startOrder() {

        //create a new order
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            int choice = menuService.showOrderScreen();

            switch (choice) {
                case 1 -> {

                    //add a torta
                    int breadChoice = menuService.promptForBreadType();
                    int sizeChoice = menuService.promptForSize();
                    boolean toastedChoice = menuService.promptForToasted() == 1;

                    Torta torta = new Torta(menuService.sizeByChoice(sizeChoice), menuService.breadByChoice(breadChoice), toastedChoice);

                    //add toppings

                    //proteins
                    menuService.promptForProteins()
                            .forEach(torta::addProtein);

                    //cheeses
                    menuService.promptForCheeses()
                            .forEach(torta::addCheese);

                    //veggies
                    menuService.promptForVeggies()
                            .forEach(torta::addVeggie);

                    //sauces
                    menuService.promptForSauces()
                            .forEach(torta::addSauce);

                    order.addItem(torta);
                }

                case 2 -> {

                    //add a drink
                    int drinkChoice = menuService.promptForDrink();
                    String drinkName = menuService.drinkByChoice(drinkChoice);
                    int sizeChoice = menuService.promptForDrinkSize();

                    if (drinkChoice != 0 && drinkName != null) {
                            order.addItem(new Drink(drinkName, menuService.sizeByChoice(sizeChoice)));
                    }
                }

                case 3 -> {

                    //add chips
                    int chipChoice = menuService.promptForChips();
                    String chipName = menuService.chipsByChoice(chipChoice);

                    if (chipName != null) {
                        order.addItem(new Chips(chipName));
                    }
                }

                case 4 -> {

                    //add a dessert
                    int dessertChoice = menuService.promptForDessert();
                    String dessertName = menuService.dessertByChoice(dessertChoice);

                    if (dessertName != null) {
                        order.addItem(new Dessert(dessertName));
                    }
                }

                case 5 -> {

                    //checkout
                    menuService.displayCheckoutSummary(order);

                    if (menuService.confirmCheckout() == 1) {
                        System.out.println("\n✅ Order confirmed!\n");
                        ReceiptWriter.saveReceipt(order);
                    } else {
                        menuService.displayOrderCancelled();
                    }
                    ordering = false;
                }

                case 0 -> {

                    //cancel order
                    System.out.println("\n❌ Order cancelled.\n");
                    ordering = false;
                }

                default -> System.out.println("⚠️ Invalid selection. Try again.");
            }
        }
    }

    //method for printing things out slowly
    public static void printSlowly() {

        //helps it print out the next thing slowly
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}