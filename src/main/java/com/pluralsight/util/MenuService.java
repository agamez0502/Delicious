package com.pluralsight.util;

import com.pluralsight.models.Order;
import com.pluralsight.models.ToppingSelection;

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

    //displayWelcomeScreen
    public void displayWelcomeScreen() {
        //welcome message
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  Welcome to Alondra's Mexican Torta-Licious Application!  ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println("\n");
    }

    //showHomeScreen
    public int showHomeScreen() {
        //homescreen menu
        System.out.println("=========== \uD83C\uDFE6 Home Screen ===========");
        System.out.println("1) \uD83C\uDD95 New Order");
        System.out.println("0) \uD83D\uDEAA Exit");
        return readInt("Make a selection: ", 0, 1);
    }

    //showOrderMenu
    public int showOrderScreen() {
        //print order screen menu
        System.out.println("\n=========== \uD83E\uDDFA Order Screen ===========");
        System.out.println("1) \uD83E\uDD6A Add Torta ");
        System.out.println("2) \uD83E\uDD64 Add Drink");
        System.out.println("3) \uD83C\uDF5F Add Chips");
        System.out.println("4) 🍰 Add Dessert");
        System.out.println("5) \uD83D\uDCB3 Checkout");
        System.out.println("0) ❌ Cancel Order");
        return readInt("Make a selection: ", 0, 5);
    }

    //promptForBreadType
    public int promptForBreadType() {
        //print list of bread types
        System.out.println("\n=========== \uD83C\uDF5E Available Bread Types ===========");
        System.out.println("1) \uD83E\uDD56 Bolillo (Regular Flour)");
        System.out.println("2) \uD83C\uDF3E Bolillo (Whole Wheat)");
        System.out.println("3) \uD83C\uDF54 Telera (Sesame Seed)");
        System.out.println("4) \uD83C\uDF5E Pan Integral (Whole Grain)");
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
        System.out.println("\n=========== ♨\uFE0F Would You Like Your Bread Toasted? ===========");
        System.out.println("1) ✅ Yes");
        System.out.println("2) ❌ No");
        return readInt("Make a selection: ", 1, 2);
    }

    //promptForProteins
    public List<ToppingSelection> promptForProteins() {
            List<ToppingSelection> proteins = new ArrayList<>();

        //possible loop (one or multiple proteins?):
        while (true) {
            System.out.println("\n=========== \uD83C\uDF56 Available Protein Options ===========");
            System.out.println("1) \uD83C\uDF56 Ham");
            System.out.println("2) \uD83C\uDF57 Pollo Asado (Grilled Chicken)");
            System.out.println("3) \uD83E\uDD69 Carne Asada (Grilled Steak)");
            System.out.println("4) \uD83D\uDC16 Carnitas (Slow-Cooked Pork)");
            System.out.println("5) \uD83C\uDF5B Milanesa (Breaded Steak or Chicken)");
            System.out.println("6) \uD83C\uDF2D Chorizo ");
            System.out.println("7) \uD83D\uDC04 Barbacoa (Slow-Cooked Beef)");
            System.out.println("8) ✅ Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("8")) {
                break;
            }

            String proteinSelection;
            switch (input) {
                case "1" -> proteinSelection = "Ham";
                case "2" -> proteinSelection = "Pollo Asado";
                case "3" -> proteinSelection = "Carne Asada";
                case "4" -> proteinSelection = "Carnitas";
                case "5" -> proteinSelection = "Milanesa";
                case "6" -> proteinSelection = "Chorizo";
                case "7" -> proteinSelection = "Barbacoa";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra meat? (yes or no)
            System.out.println("\nWould you like extra " + proteinSelection + "?");
            System.out.println("1) ✅ Yes");
            System.out.println("2) ❌ No");
            System.out.print("Make a selection: ");
            String extraInput = menuScanner.nextLine().trim();
            boolean isExtra = extraInput.equals("1");

            proteins.add(new ToppingSelection(proteinSelection, isExtra));
        }
        //return list of meats and extras
        return proteins;
    }

    //promptForCheeses
    public List<ToppingSelection> promptForCheeses() {
        List<ToppingSelection> cheeses = new ArrayList<>();

        //possible loop (one or multiple cheeses?):
        while (true) {
            System.out.println("\n=========== \uD83E\uDDC0 Available Cheese Options ===========");
            System.out.println("1) \uD83E\uDDC0 Queso Oaxaca (String Cheese)");
            System.out.println("2) \uD83E\uDDC0 Queso Fresco");
            System.out.println("3) \uD83E\uDDC0 Mozzarella Cheese");
            System.out.println("4) \uD83E\uDDC0 Cotija Cheese");
            System.out.println("5) \uD83E\uDDC0 Queso Panela");
            System.out.println("6) \uD83E\uDDC0 Chihuahua Cheese");
            System.out.println("7) ✅ Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("7")) {
                break;
            }

            String cheeseSelection;
            switch (input) {
                case "1" -> cheeseSelection = "Queso Oaxaca";
                case "2" -> cheeseSelection = "Queso Fresco";
                case "3" -> cheeseSelection = "Mozzarella Cheese";
                case "4" -> cheeseSelection = "Cotija Cheese";
                case "5" -> cheeseSelection = "Queso Panela";
                case "6" -> cheeseSelection = "Chihuahua Cheese";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra cheese? (yes or no)
            System.out.println("\nWould you like extra " + cheeseSelection + "?");
            System.out.println("1) ✅ Yes");
            System.out.println("2) ❌ No");
            System.out.print("Make a selection: ");
            String extraInput = menuScanner.nextLine().trim();
            boolean isExtra = extraInput.equals("1");

            cheeses.add(new ToppingSelection(cheeseSelection, isExtra));
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
            System.out.println("1) \uD83E\uDD6C Lettuce");
            System.out.println("2) \uD83C\uDF45 Tomato");
            System.out.println("3) \uD83E\uDDC5 Onion");
            System.out.println("4) \uD83E\uDD51 Avocado");
            System.out.println("5) \uD83C\uDF36\uFE0F Jalapeños");
            System.out.println("6) \uD83E\uDED8 Refried Beans");
            System.out.println("7) ✅ Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("7")) {
                break;
            }

            String veggieSelection;
            switch (input) {
                case "1" -> veggieSelection = "Lettuce";
                case "2" -> veggieSelection = "Tomato";
                case "3" -> veggieSelection = "Onion";
                case "4" -> veggieSelection = "Avocado";
                case "5" -> veggieSelection = "Jalapeños";
                case "6" -> veggieSelection = "Refried Beans";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra veggies? (yes or no)
            System.out.println("\nWould you like extra " + veggieSelection + "?");
            System.out.println("1) ✅ Yes");
            System.out.println("2) ❌ No");
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
            System.out.println("1) \uD83E\uDD5B Crema Mexicana");
            System.out.println("2) \uD83E\uDD5A Mayonnaise");
            System.out.println("3) \uD83C\uDF36\uFE0F Chipotle Sauce");
            System.out.println("4) \uD83E\uDD51 Salsa Verde");
            System.out.println("5) \uD83C\uDF45 Salsa Roja");
            System.out.println("6) ✅ Done");
            System.out.print("Make a selection: ");
            String input = menuScanner.nextLine().trim();

            if (input.equals("6")) {
                break;
            }

            String sauceSelection;
            switch (input) {
                case "1" -> sauceSelection = "Crema Mexicana";
                case "2" -> sauceSelection = "Mayonnaise";
                case "3" -> sauceSelection = "Chipotle Sauce";
                case "4" -> sauceSelection = "Salsa Verde";
                case "5" -> sauceSelection = "Salsa Roja";
                default -> {
                    System.out.println("⚠️ Invalid selection. Please try again.");
                    continue;
                }
            };

            //ask if they want Extra sauce? (yes or no)
            System.out.println("\nWould you like extra " + sauceSelection + "?");
            System.out.println("1) ✅ Yes");
            System.out.println("2) ❌ No");
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
        System.out.println("1) \uD83E\uDD64 Mexican Coca-Cola");
        System.out.println("2) \uD83C\uDF53 Jarrito (Strawberry)");
        System.out.println("3) \uD83C\uDF4D Agua de Piña (Pineapple Water)");
        System.out.println("4) \uD83C\uDF3A Agua de Jamaica (Hibiscus Tea)");
        System.out.println("5) \uD83E\uDD5B Horchata");
        return readInt("Make a selection: ", 1, 5);
    }

    //promptForSize
    public int promptForDrinkSize() {
        //ask user: "What size? (4, 8, or 12 inches)"
        System.out.println("\n=========== What Size? ===========");
        System.out.println("1) Chico");
        System.out.println("2) Mediano");
        System.out.println("3) Grande");
        return readInt("Make a selection: ", 1, 3);
    }

    //promptForChips
    public int promptForChips() {
        //print list of chip types
        System.out.println("\n=========== \uD83C\uDF5F Available Chip Types ===========");
        System.out.println("1) \uD83C\uDF36\uFE0F\uD83D\uDD25 Takis");
        System.out.println("2) \uD83C\uDF4B\uD83C\uDF36\uFE0F Sabritones (Chili-Lime)");
        System.out.println("3) \uD83E\uDDC0\uD83D\uDD3A Doritos");
        System.out.println("4) \uD83E\uDDC0\uD83E\uDD54 Ruffles Queso (Mexican Cheese)");
        return readInt("Make a selection: ", 1, 4);
    }

    //promptForDessert
    public int promptForDessert() {
        System.out.println("\n=========== 🍰 Available Desserts ===========");
        System.out.println("1) \uD83C\uDF6E Flan");
        System.out.println("2) \uD83C\uDF6B Choco-Flan");
        System.out.println("3) \uD83C\uDF1F Churro");
        System.out.println("4) \uD83C\uDF70 Tres Leches Cake");
        return readInt("Make a selection: ", 1, 4);
    }

    //displayCheckoutSummary
    public void displayCheckoutSummary(Order order) {
        //display full order summary and price
        System.out.println("\n=========== \uD83E\uDDFE Order Summary ===========");
        System.out.println(order);
    }

    //confirmCheckout
    public int confirmCheckout() {
        //ask to confirm order
        System.out.println("\n=========== ✅ Confirm Order ===========");
        System.out.println("1) ✅ Yes");
        System.out.println("2) ❌ No");
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

    //mapping helpers
    public String breadByChoice(int c) {
        return switch (c) {
            case 1 -> "Bolillo (Regular Flour)";
            case 2 -> "Bolillo (Whole Wheat)";
            case 3 -> "Telera (Sesame Seed)";
            case 4 -> "Pan Integral (Whole Grain)";
            default -> "Bolillo (Regular Flour)";
        };
    }

    public String sizeByChoice(int c) {
        return switch (c) {
            case 1 -> "Chico";
            case 2 -> "Mediano";
            case 3 -> "Grande";
            default -> "Chico";
        };
    }

    public String drinkByChoice(int c) {
        return switch (c) {
            case 1 -> "Mexican Coca-Cola";
            case 2 -> "Jarrito (Strawberry)";
            case 3 -> "Agua de Piña";
            case 4 -> "Agua de Jamaica";
            case 5 -> "Horchata";
            default -> "Mexican Coca-Cola";
        };
    }

    public String chipsByChoice(int c) {
        return switch (c) {
            case 1 -> "Takis";
            case 2 -> "Sabritones (Chili-Lime)";
            case 3 -> "Doritos";
            case 4 -> "Ruffles Queso";
            default -> null;
        };
    }

    public String dessertByChoice(int c) {
        return switch (c) {
            case 1 -> "Flan";
            case 2 -> "Choco-Flan";
            case 3 -> "Churro";
            case 4 -> "Tres Leches Cake";
            default -> null;
        };
    }
}