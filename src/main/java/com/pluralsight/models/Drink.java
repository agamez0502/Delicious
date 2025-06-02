package com.pluralsight.models;

import com.pluralsight.ui.OrderItem;

public class Drink implements OrderItem {

    //properties=================================================================================
    private String flavor;
    private String size;
    private double price;

    //constructor================================================================================
    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;

        //set base price based on size
        switch (size) {
            case "Chico":
                this.price = 2.00;
                break;
            case "Mediano":
                this.price = 2.50;
                break;
            case "Grande":
                this.price = 3.00;
                break;
            default:
                System.out.println("Invalid selection ❌");
        }
    }

    //methods====================================================================================
    //implement from OrderItem - getPrice method that returns current total price
    @Override
    public double getPrice() {
        return price;
    }

    //implement from OrderItem - getSummary method that returns a string with all drink details and price
    @Override
    public String getSummary() {
        return "🥤 Drink: " + size + " " + flavor + " - $" + String.format("%.2f", price);
    }

    //getters and setters========================================================================
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

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