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

        //create a torta
        int breadChoice = menuService.promptForBreadType();
        int sizeChoice = menuService.promptForSize();
        boolean toastedChoice = menuService.promptForToasted() == 1;

        Torta torta = new Torta(menuService.sizeByChoice(sizeChoice), menuService.breadByChoice(breadChoice), toastedChoice);

        //add toppings

        //proteins
        menuService.promptForProteins()
                .forEach(s -> {
                    boolean extra = s.endsWith(" (extra)");
                    String name   = extra ? s.substring(0, s.length() - " (extra)".length()) : s;
                    addProtein(s.name, extra);
                });

        //cheeses
        menuService.promptForCheeses()
                .forEach(c -> addCheese(c.getName(), c.isExtra()));

        //veggies
        menuService.promptForVeggies()
                .forEach(v -> torta.addVeggie(v));

        //sauces
        menuService.promptForSauces()
                .forEach(s -> torta.addSauce(s));

        order.addItem(torta);

        //create a drink
        int drinkChoice = menuService.promptForDrink();

        if (drinkChoice != 0) {
            order.addItem(new Drink(menuService.drinkByChoice(drinkChoice), menuService.sizeByChoice(sizeChoice)));
        }

        //create chips
        int chipChoice = menuService.promptForChips();
        String chipName = menuService.chipsByChoice(chipChoice);

        if (chipName != null) {
            order.addItem(new Chips(chipName));
        }

        //create a dessert
        int dessertChoice = menuService.promptForDessert();
        String dessertName = menuService.dessertByChoice(dessertChoice);

        if (dessertName != null) {
            order.addItem(new Dessert(dessertName));
        }

        //summary - confirm order
        menuService.displayCheckoutSummary(order);

        if (menuService.confirmCheckout() == 1) {
            System.out.println("✅ Order confirmed!");
            ReceiptWriter.saveReceipt(order);
        } else {
            menuService.displayOrderCancelled();
        }
    }
}