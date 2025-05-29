package com.pluralsight.models;

public class Drink {
    //properties=================================================================================
    private String size;
    private String flavor;
    private double price;

    //constructor================================================================================
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

        if (size.equalsIgnoreCase("Chico")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("Mediano")) {
            price = 2.50;
        } else if (size.equalsIgnoreCase("Grande")) {
            price = 3.00;
        }
    }

    //methods====================================================================================
    @Override
    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", price);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}