package com.pluralsight.models;

import com.pluralsight.ui.OrderItem;

public class Chips implements OrderItem {

    //properties=================================================================================
    private String flavor;
    private double price = 1.50; //fixed price

    //constructor================================================================================
    public Chips(String flavor) {
        this.flavor = flavor;
    }

    //methods====================================================================================
    //implement from OrderItem - getPrice method that returns current total price
    @Override
    public double getPrice() {
        return price;
    }

    //implement from OrderItem - getSummary method that returns a string with all chip details and price
    @Override
    public String getSummary() {
        return "\uD83C\uDF5F Chips: " + flavor + " - $" + String.format("%.2f", price);
    }

    //getters and setters========================================================================
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}