package com.pluralsight.models;

public class Chips {
    //properties=================================================================================
    private String name;
    private double price;

    //constructor================================================================================
    public Chips(String name) {
        this.name = name;
        this.price = 1.50;
    }

    //methods====================================================================================
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }

    // getters and setters========================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}