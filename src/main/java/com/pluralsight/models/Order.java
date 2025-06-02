package com.pluralsight.models;

import com.pluralsight.ui.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Order {

    //properties=================================================================================
    private List<OrderItem> items = new ArrayList<>();

//    //constructor================================================================================
//    public Order(List<OrderItem> items) {
//        this.items = items;
//    }

    //methods====================================================================================
    //addItem method that adds item to list
    public void addItem(OrderItem item) {
        items.add(item);
    }

    //getTotal method that returns total price of order
    public double getTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    //getOrderSummary method that returns formatted string of all items and total
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();

        for (OrderItem item : items) {
            summary.append("").append(item.getSummary()).append("\n");
        }
        summary.append("═════════════════════════════════\n");
        summary.append("\uD83D\uDCB0 Total: $").append(String.format("%.2f", getTotal()));

        return summary.toString();
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();

        string.append("Your order includes:\n");
        for (OrderItem item : items) {
            string.append("").append(item.getSummary()).append("\n");
        }

        string.append(String.format("\uD83D\uDCB2 Total Price: $%.2f", getTotal()));
        return string.toString();
    }

    //getters and setters========================================================================
    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}