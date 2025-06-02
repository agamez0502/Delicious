package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    //declare a Scanner object for reading input from the console
    Scanner menuScanner = new Scanner(System.in);

    //method for choosing a number instead of typing it
    private int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = Integer.parseInt(menuScanner.nextLine().trim());
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("⚠️  Enter a number between " + min + " and " + max);
        }
    }

    //showHomeScreen
    public int showHomeScreen() {
        //welcome message
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  Welcome to Alondra's Mexican Torta-Licious Application!  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println("\n=========== \uD83C\uDFE6 Home Screen ===========");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        return readInt("Make a selection: ", 0, 1);
    }

    //showOrderMenu
    public int showOrderScreen() {
        //print order screen menu
        System.out.println("\n=========== \uD83E\uDDFA Order Screen ===========");
        System.out.println("1) \uD83E\uDD6A Add Torta ");
        System.out.println("2) \uD83E\uDD64 Add Drink");
        System.out.println("3) \uD83C\uDF5F Add Chips");
        System.out.println("4) \uD83D\uDCB3 Checkout");
        System.out.println("0) ❌ Cancel Order");
        return readInt("Make a selection: ", 0, 4);
    }

    //promptForBreadType
    public int promptForBreadType() {
        //print list of bread types
        System.out.println("\n=========== \uD83E\uDD56 Available Bread Types ===========");
        System.out.println("1) Bolillo (Regular Flour)");
        System.out.println("2) Bolillo (Whole Wheat)");
        System.out.println("3) Telera (Sesame Seed)");
        System.out.println("4) Pan Integral (Whole Grain)");
        return readInt("Make a selection: ", 1, 4);
    }

    //promptForSize
    public int promptForSize() {
        //ask user: "What size? (4, 8, or 12 inches)"
        System.out.println("\n=========== What Size? ===========");
        System.out.println("1) Chico   (4 inch)");
        System.out.println("2) Mediano (8 inch)");
        System.out.println("3) Grande  (12 inch)");
        return readInt("Make a selection: ", 1, 3);
    }

    //promptForToasted
    public int promptForToasted() {
        //ask: "Would you like it toasted? (yes or no)"
        System.out.println("\n=========== Would you like your bread toasted? ===========");
        System.out.println("1) Yes");
        System.out.println("2) No");
        return readInt("Make a selection: ", 1, 2);
    }

    //promptForProteins
    public List<String> promptForProteins() {
        List<String> proteins = new ArrayList<>();
        //possible loop (one or multiple proteins?):
        while (true) {
            System.out.println("\n=========== \uD83C\uDF56 Available Protein Options ===========");
            System.out.println("1) Ham");
            System.out.println("2) Pollo Asado (Grilled Chicken)");
            System.out.println("3) Carne Asada (Grilled Steak)");
            System.out.println("4) Carnitas (Slow-Cooked Pork)");
            System.out.println("5) Milanesa (Breaded Steak or Chicken)");
            System.out.println("6) Chorizo ");
            System.out.println("7) Barbacoa (Slow-Cooked Beef)");
            System.out.println("8) Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("8")) {
                break;
            }

            String proteinSelection = switch (input) {
                case "1" -> "Ham";
                case "2" -> "Pollo Asado";
                case "3" -> "Carne Asada";
                case "4" -> "Carnitas";
                case "5" -> "Milanesa";
                case "6" -> "Chorizo";
                case "7" -> "Barbacoa";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra meat? (yes or no)
            System.out.println("Would you like extra " + proteinSelection + "?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.println("Make a selection: ");
            String extraInput = menuScanner.nextLine().trim();

            if (extraInput.equals("1")) {
                proteins.add(proteinSelection + " (extra)");
            } else {
                proteins.add(proteinSelection);
            }
        }
        //return list of meats and extras
        return proteins;
    }

    //promptForCheeses
    public List<String> promptForCheeses() {
        List<String> cheeses = new ArrayList<>();
        //possible loop (one or multiple cheeses?):
        while (true) {
            System.out.println("\n=========== \uD83E\uDDC0 Available Cheese Options ===========");
            System.out.println("1) Queso Oaxaca (String Cheese)");
            System.out.println("2) Queso Fresco");
            System.out.println("3) Mozzarella Cheese");
            System.out.println("4) Cotija Cheese");
            System.out.println("5) Queso Panela");
            System.out.println("6) Chihuahua Cheese");
            System.out.println("7) Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("7")) {
                break;
            }

            String cheeseSelection = switch (input) {
                case "1" -> "Queso Oaxaca";
                case "2" -> "Queso Fresco";
                case "3" -> "Mozzarella Cheese";
                case "4" -> "Cotija Cheese";
                case "5" -> "Queso Panela";
                case "6" -> "Chihuahua Cheese";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra cheese? (yes or no)
            System.out.println("Would you like extra " + cheeseSelection + "?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.println("Make a selection: ");
            String extraInput = menuScanner.nextLine().trim();

            if (extraInput.equals("1")) {
                cheeses.add(cheeseSelection + " (extra)");
            } else {
                cheeses.add(cheeseSelection);
            }
        }
        //return list of cheese and extras
        return cheeses;
    }

    //promptForVeggies
    public List<String> promptForVeggies() {
        List<String> veggies = new ArrayList<>();
        //possible loop (one or multiple veggies?):
        while (true) {
            System.out.println("\n=========== \uD83E\uDD6C Available Veggie Options ===========");
            System.out.println("1) Lettuce");
            System.out.println("2) Tomato");
            System.out.println("3) Onion");
            System.out.println("4) Avocado");
            System.out.println("5) Jalapeños");
            System.out.println("6) Refried Beans");
            System.out.println("7) Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("7")) {
                break;
            }

            String veggieSelection = switch (input) {
                case "1" -> "Lettuce";
                case "2" -> "Tomato";
                case "3" -> "Onion";
                case "4" -> "Avocado";
                case "5" -> "Jalapeños";
                case "6" -> "Refried Beans";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra veggies? (yes or no)
            System.out.println("Would you like extra " + veggieSelection + "?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.print("Make a selection: ");
            String extraInput = menuScanner.nextLine().trim();

            if (extraInput.equals("1")) {
                veggies.add(veggieSelection + " (extra)");
            } else {
                veggies.add(veggieSelection);
            }
        }
        //return list of veggies and extras
        return veggies;
    }

    //promptForSauces
    public List<String> promptForSauces() {
        List<String> sauces = new ArrayList<>();
        //possible loop (one or multiple sauces?):
        while (true) {
            System.out.println("\n=========== \uD83C\uDF36\uFE0F Available Sauce Options ===========");
            System.out.println("1) Crema Mexicana");
            System.out.println("2) Mayonnaise");
            System.out.println("3) Chipotle Sauce");
            System.out.println("4) Salsa Verde");
            System.out.println("5) Salsa Roja");
            System.out.println("6) Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("6")) {
                break;
            }

            String sauceSelection = switch (input) {
                case "1" -> "Crema Mexicana";
                case "2" -> "Mayonnaise";
                case "3" -> "Chipotle Sauce";
                case "4" -> "Salsa Verde";
                case "5" -> "Salsa Roja";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra sauce? (yes or no)
            System.out.println("Would you like extra " + sauceSelection + "?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.print("Make a selection: ");
            String extraInput = menuScanner.nextLine().trim();

            if (extraInput.equals("1")) {
                sauces.add(sauceSelection + " (extra)");
            } else {
                sauces.add(sauceSelection);
            }
        }
        //return list of sauces and extras
        return sauces;
    }

    //promptForDrink
    public int promptForDrink() {
        //print list of drink flavors
        System.out.println("\n=========== \uD83E\uDD64 Available Drink Flavors ===========");
        System.out.println("1) Mexican Coca-Cola");
        System.out.println("2) Jarrito (Strawberry)");
        System.out.println("3) Agua de Piña (Pineapple Water)");
        System.out.println("4) Agua de Jamaica (Hibiscus Tea)");
        System.out.println("5) Horchata");
        return readInt("Make a selection: ", 1, 5);

        //prompt for size
    }

    //promptForChips
    public int promptForChips() {
        //print list of chip types
        System.out.println("\n=========== \uD83C\uDF5F Available Chip Types ===========");
        System.out.println("1) Takis");
        System.out.println("2) Sabritones (Chili-Lime)");
        System.out.println("3) Doritos");
        System.out.println("4) Ruffles Queso (Mexican Cheese)");
        return readInt("Make a selection: ", 1, 4);
    }

    //promptForDessert
    public int promptForDessert() {
        System.out.println("\n=========== 🍰 Available Desserts ===========");
        System.out.println("1) \uD83C\uDF6E Flan");
        System.out.println("2) \uD83C\uDF1F Churro");
        System.out.println("3) \uD83C\uDF70 Tres Leches Cake");
        return readInt("Make a selection: ", 1, 3);
    }

    //displayCheckoutSummary
    public void displayCheckoutSummary(Order order) {
        //display full order summary and price
        System.out.println("\n=========== Order Summary ===========");
        System.out.println(order);
    }

    //confirmCheckout
    public int confirmCheckout() {
        //ask to confirm order
        System.out.println("\n=========== Confirm Order ===========");
        System.out.println("1) Yes");
        System.out.println("2) No");
        return readInt("Make a selection: ", 1, 2);

        //generate receipt file
    }

    //displayOrderCancelled
    public void displayOrderCancelled() {
        //discard order
        System.out.println("\n❌ Your order has been cancelled.");
    }

    //displayExitScreen
    public void displayExitScreen() {
        System.out.println("\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  Thank you for choosing Alondra's Mexican Torta-Licious Application!  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════╝");
    }
}