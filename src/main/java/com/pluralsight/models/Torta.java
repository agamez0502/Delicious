package com.pluralsight.models;

import com.pluralsight.ui.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Torta implements OrderItem {

    //properties=================================================================================
    private String size;
    private String breadType;
    private boolean isToasted;
    private List<ToppingSelection> proteins = new ArrayList<>();
    private List<ToppingSelection> cheeses = new ArrayList<>();
    private List<ToppingSelection> veggies = new ArrayList<>();
    private List<ToppingSelection> sauces = new ArrayList<>();
    private double basePrice;
    private double totalPrice;

    //constructor================================================================================
    public Torta(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;

        //set base price based on size
        if (size.equalsIgnoreCase("Chico")) {
            basePrice = 5.50;
        } else if (size.equalsIgnoreCase("Mediano")) {
            basePrice = 7.00;
        } else if (size.equalsIgnoreCase("Grande")) {
            basePrice = 8.50;
        }
        totalPrice = basePrice;
    }

    //methods====================================================================================
    //addProtein method that adds meat(s), what is the price based on size and whether it's extra?
    public void addProtein(ToppingSelection selection) {
        proteins.add(selection);

        if (size.equalsIgnoreCase("Chico")) {
            if (selection.isExtra()) {
                totalPrice += 0.50 + 1.00;
            } else {
                totalPrice += 1.00;
            }
        } else if (size.equalsIgnoreCase("Mediano")) {
            if (selection.isExtra()) {
                totalPrice += 1.00 + 2.00;
            } else {
                totalPrice += 2.00;
            }
        } else if (size.equalsIgnoreCase("Grande")) {
            if (selection.isExtra()) {
                totalPrice += 1.50 + 3.00;
            } else {
                totalPrice += 3.00;
            }
        }
    }

    //addCheese method that adds cheese(s) and price depending on size and whether it's extra
    public void addCheese(ToppingSelection selection) {
        cheeses.add(selection);

        if (size.equalsIgnoreCase("Chico")) {
            if (selection.isExtra()) {
                totalPrice += 0.30 + 0.75;
            } else {
                totalPrice += 0.75;
            }
        } else if (size.equalsIgnoreCase("Mediano")) {
            if (selection.isExtra()) {
                totalPrice += 0.60 + 1.50;
            } else {
                totalPrice += 1.50;
            }
        } else if (size.equalsIgnoreCase("Grande")) {
            if (selection.isExtra()) {
                totalPrice += 0.90 + 2.25;
            } else {
                totalPrice += 2.25;
            }
        }
    }

    //addVeggies method that adds veggie(s) at no charge
    public void addVeggie(String name) {
        veggies.add(new ToppingSelection(name, false));
    }

    //addSauce method that adds sauce(s) at no charge
    public void addSauce(String name) {
        sauces.add(new ToppingSelection(name, false));
    }

    //implement from OrderItem - getPrice method that returns current total price
    @Override
    public double getPrice() {
        return totalPrice;
    }

    //implement from OrderItem - getSummary method that returns a string with all sandwich details and price
    @Override
    public String getSummary() {
        StringBuilder summary = new StringBuilder();

        summary.append("\uD83E\uDD6A Size: ").append(size).append("\n");
        summary.append("\uD83C\uDF5E Bread: ").append(breadType).append("\n");
        summary.append("\uD83D\uDD25 Toasted: ").append(isToasted ? "Yes ✅" : "No ❌").append("\n");

        summary.append("🍖 Proteins: ");
        for (ToppingSelection t : proteins) {
            summary.append(t.getName());
            if (t.isExtra()) {
                summary.append(" (extra)");
            }
            summary.append(", ");
        }
        summary.append("\n");

        summary.append("🧀 Cheeses: ");
        for (ToppingSelection t : cheeses) {
            summary.append(t.getName());
            if (t.isExtra()) {
                summary.append(" (extra)");
            }
            summary.append(", ");
        }
        summary.append("\n");

        summary.append("🥬 Veggies: ");
        for (ToppingSelection t : veggies) {
            summary.append(t.getName()).append(", ");
        }
        summary.append("\n");

        summary.append("🌶️ Sauces: ");
        for (ToppingSelection t : sauces) {
            summary.append(t.getName()).append(", ");
        }
        summary.append("\n");

        summary.append("---------------------------------");
        summary.append("\n💲 Torta Price: $").append(String.format("%.2f", totalPrice));

        return summary.toString();
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

    public List<ToppingSelection> getProteins() {
        return proteins;
    }

    public void setProteins(List<ToppingSelection> proteins) {
        this.proteins = proteins;
    }

    public List<ToppingSelection> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<ToppingSelection> cheeses) {
        this.cheeses = cheeses;
    }

    public List<ToppingSelection> getVeggies() {
        return veggies;
    }

    public void setVeggies(List<ToppingSelection> veggies) {
        this.veggies = veggies;
    }

    public List<ToppingSelection> getSauces() {
        return sauces;
    }

    public void setSauces(List<ToppingSelection> sauces) {
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