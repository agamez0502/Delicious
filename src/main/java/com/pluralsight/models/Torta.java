package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Torta {

    //properties=================================================================================
    //store bread type (white, wheat, rye, wrap)
    //store sandwich size (4, 8, or 12 inches)
    //store if sandwich is toasted
    //store meats, cheeses, toppings, sauces
    //keep track of total price
    private String size;
    private String breadType;
    private boolean isToasted;
    private List<Toppings> proteins = new ArrayList<>();
    private List<Toppings> cheeses = new ArrayList<>();
    private List<Toppings> veggies = new ArrayList<>();
    private List<Toppings> sauces = new ArrayList<>();
    private double basePrice;
    private double totalPrice;
git 
    //constructor================================================================================
    //takes bread type, size, toasted
    //initialize properties
    public Torta(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;

        //set base price based on size
        if (size.equalsIgnoreCase("chico")) {
            basePrice = 5.50;
        } else if (size.equalsIgnoreCase("mediano")) {
            basePrice = 7.00;
        } else if (size.equalsIgnoreCase("grande")) {
            basePrice = 8.50;
        }
        totalPrice = basePrice;
    }

    //methods====================================================================================
    //addProtein method that adds meat(s), what is the price based on size and whether it's extra?
    public void addProtein(String name, boolean isExtra) {
        Toppings topping = new Toppings(name, "protein", isExtra);
        proteins.add(topping);

        if (size.equalsIgnoreCase("chico")) {
            if (isExtra) {
                totalPrice = totalPrice + 0.50;
            } else {
                totalPrice = totalPrice + 1.00;
            }
        } else if (size.equalsIgnoreCase("mediano")) {
            if (isExtra) {
                totalPrice = totalPrice + 1.00;
            } else {
                totalPrice = totalPrice + 2.00;
            }
        } else if (size.equalsIgnoreCase("grande")) {
            if (isExtra) {
                totalPrice = totalPrice + 1.50;
            } else {
                totalPrice = totalPrice + 3.00;
            }
        }
    }

    //addCheese method that adds cheese(s) and price depending on size and whether it's extra
    public void addCheese(String name, boolean isExtra) {
        Toppings topping = new Toppings(name, "cheese", isExtra);
        cheeses.add(topping);

        if (size.equalsIgnoreCase("chico")) {
            if (isExtra) {
                totalPrice = totalPrice + 0.30;
            } else {
                totalPrice = totalPrice + 0.75;
            }
        } else if (size.equalsIgnoreCase("mediano")) {
            if (isExtra) {
                totalPrice = totalPrice + 0.60;
            } else {
                totalPrice = totalPrice + 1.50;
            }
        } else if (size.equalsIgnoreCase("grande")) {
            if (isExtra) {
                totalPrice = totalPrice + 0.90;
            } else {
                totalPrice = totalPrice + 2.25;
            }
        }
    }

    //addVeggies method that adds veggie(s) at no charge
    public void addVeggie(String name) {
        Toppings topping = new Toppings(name, "veggie", false);
        veggies.add(topping);
    }

    //addSauce method that adds sauce(s) at no charge
    public void addSauce(String name) {
        Toppings topping = new Toppings(name, "sauce", false);
        sauces.add(topping);
    }

    // getPrice method that returns current total price
    public double getPrice() {
        return totalPrice;
    }

    // getSummary method that returns a string with all sandwich details and price
    public String getSummary() {
        String summary = "";

        summary = summary + "Size: " + size + "\n";
        summary = summary + "Bread: " + breadType + "\n";

        if (isToasted) {
            summary = summary + "Toasted: Yes\n";
        } else {
            summary = summary + "Toasted: No\n";
        }

        summary = summary + "Proteins: ";
        for (Toppings t : proteins) {
            summary = summary + t.getName();
            if (t.isExtra()) {
                summary = summary + " (extra)";
            }
            summary = summary + ", ";
        }
        summary = summary + "\n";

        summary = summary + "Cheeses: ";
        for (Toppings t : cheeses) {
            summary = summary + t.getName();
            if (t.isExtra()) {
                summary = summary + " (extra)";
            }
            summary = summary + ", ";
        }
        summary = summary + "\n";

        summary += "Veggies: ";
        for (Toppings t : veggies) {
            summary = summary + t.getName() + ", ";
        }
        summary = summary + "\n";

        summary += "Sauces: ";
        for (Toppings t : sauces) {
            summary = summary + t.getName() + ", ";
        }
        summary = summary + "\n";

        summary = summary + "Torta Price: $" + String.format("%.2f", totalPrice);

        return summary;
    }

    //getters and setters========================================================================
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Toppings> getProteins() {
        return proteins;
    }

    public void setProteins(List<Toppings> proteins) {
        this.proteins = proteins;
    }

    public List<Toppings> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<Toppings> cheeses) {
        this.cheeses = cheeses;
    }

    public List<Toppings> getVeggies() {
        return veggies;
    }

    public void setVeggies(List<Toppings> veggies) {
        this.veggies = veggies;
    }

    public List<Toppings> getSauces() {
        return sauces;
    }

    public void setSauces(List<Toppings> sauces) {
        this.sauces = sauces;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}