//package com.pluralsight.ui;
//
//import com.pluralsight.models.Order;
//import com.pluralsight.models.Torta;
//import com.pluralsight.util.MenuService;
//
//public class UserInterface {
//    private MenuService menuService = new MenuService();
//
//    public void run() {
//        boolean running = true;
//
//        while (running) {
//            int homeSelection = menuService.showHomeScreen();
//
//            switch (homeSelection) {
//                //new order
//                case 1:
//                    Order order = new Order();
//
//                    //bread selection
//                    int breadChoice = menuService.promptForBreadType();
//                    order.setBreadType(breadChoice);
//
//                    //size selection
//                    int sizeChoice = menuService.promptForSize();
//                    order.setSize(sizeChoice);
//
//                    //toasted?
//                    int toastedChoice = menuService.promptForToasted();
//                    order.setToasted(toastedChoice == 1);
//
//                    //proteins
//                    order.setProteins(menuService.promptForProteins());
//
//                    //cheeses
//                    order.setCheeses(menuService.promptForCheeses());
//
//                    //veggies
//                    order.setVeggies(menuService.promptForVeggies());
//
//                    //sauces
//                    order.setSauces(menuService.promptForSauces());
//
//                    //drinks
//                    int drinkChoice = menuService.promptForDrink();
//                    order.setDrink(drinkChoice);
//
//                    //chips
//                    int chipsChoice = menuService.promptForChips();
//                    order.setChips(chipsChoice);
//
//                    //order summary
//                    menuService.displayCheckoutSummary(order);
//
//                    int confirm = menuService.confirmCheckout();
//                    if (confirm == 1) {
//                        System.out.println("✅ Order confirmed!");
//                    } else {
//                        menuService.displayOrderCancelled();
//                    }
//                    break;
//
//                //exit
//                case 0:
//                    running = false;
//                    menuService.displayExitScreen();
//                    break;
//
//                default:
//                    System.out.println("⚠️ Invalid selection. Please try again.");
//            }
//        }
//    }
//}