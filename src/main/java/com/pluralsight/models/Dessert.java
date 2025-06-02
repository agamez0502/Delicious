package com.pluralsight.models;

import com.pluralsight.ui.OrderItem;

public class Dessert implements OrderItem {

    //properties=================================================================================
    private String name;
    private double price = 3.00;

    //constructor================================================================================
    public Dessert(String name) {
        this.name = name;
    }

    //set price based on dessert type
//    switch(name) {
//        case "Flan":
//            this.price = 2.00;
//            break;
//        case "Choco-Flan":
//            this.price = 3.00;
//            break;
//        case "Pan Dulce":
//            this.price = 1.50;
//            break;
//        case "Tres Leches Cake":
//            this.price = 3.50;
//            break;
//    }

    //methods====================================================================================
    //implement from OrderItem - getPrice method that returns current total price
    @Override
    public double getPrice() {
        return price;
    }

    //implement from OrderItem - getSummary method that returns a string with all dessert details and price
    @Override
    public String getSummary() {
        return "🍰 Dessert: " + name + " - $" + String.format("%.2f", price);
    }

    //getters and setters========================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}