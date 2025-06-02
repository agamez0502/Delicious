package com.pluralsight;

//import com.pluralsight.ui.UserInterface;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Torta;

public class App {

    public static void main(String[] args) {
        //create and populate an order
        Order order = new Order();

        Torta torta = new Torta("Grande", "White", true);
        torta.addProtein("Carnitas", false);
        torta.addProtein("Carne Asada", false);
        torta.addCheese("Queso Fresco", false);
        torta.addCheese("Cotija Cheese", false);
        torta.addVeggie("Lettuce");
        torta.addSauce("Chipotle Mayo");

        Drink drink = new Drink("Grande", "Horchata");
        Chips chips = new Chips("Chile Limón");

        order.addItem(torta);
        order.addItem(drink);
        order.addItem(chips);

        System.out.println(order.getOrderSummary());
    }
}
