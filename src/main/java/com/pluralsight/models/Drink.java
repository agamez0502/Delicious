package com.pluralsight.models;

import com.pluralsight.ui.OrderItem;

public class Drink implements OrderItem {

    //properties=================================================================================
    private String size;
    private String flavor;
    private double price;

    //constructor================================================================================
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

        System.out.println("1) Chico");
        System.out.println("2) Mediano");
        System.out.println("3) Grande");

        switch (size) {
            case "1":
                this.price = 2.00;
                break;
            case "2":
                this.price = 2.50;
                break;
            case "3":
                this.price = 3.00;
                break;
            default:
                System.out.println("Invalid selection ❌");
        }

//        //set base price based on size
//        switch (size.equalsIgnoreCase(size)) {
//            case "Chico":
//                this.price = 2.00;
//                break;
//            case "Mediano":
//                this.price = 2.50;
//                break;
//            case "Grande":
//                this.price = 3.00;
//                break;
//            default:
//                this.price = 2.00; //most common size is medium
//                break;
//        }

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