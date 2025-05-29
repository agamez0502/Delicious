package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    //properties=================================================================================
    //create List for order items (sandwiches, drinks, and chips)
    private List<Torta> tortas  = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    //store total price

    //constructor================================================================================
    //initialize the class properties
    public Order(List<Torta> tortas, List<Drink> drinks, List<Chips> chips) {
        this.tortas = tortas;
        this.drinks = drinks;
        this.chips = chips;
    }

    //methods====================================================================================
    //addSandwich method that adds sandwich to list
    public void addTorta(Torta torta){
        tortas.add(torta);
    }

    //addDrink method that adds drink to list
    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    // addChips method that adds chips to list
    public void addChips(Chips chip){
        chips.add(chip);
    }

    // getTotal method that returns total price of order
    public double getTotal(){
        double total = 0;

        for(Torta torta : tortas){
            total = total + torta.getPrice();
        }
        for(Drink drink : drinks){
            total = total + drink.getPrice();
        }
        for(Chips chip : chips){
            total = total + chip.getPrice();
        }
        return total;
    }

    // getOrderSummary method that returns formatted string of all items and total
    public getOrderSummary(){
        String summary = "";

        summary = summary + "Tortas:\n";
        for(Torta torta : tortas){
            summary = summary + torta.getSummary() + "\n";
        }

        summary = summary + "Drinks:\n";
        for(Drink drink : drinks){
            summary = summary + drink.toString() + "\n";
        }

        summary = summary + "Chips:\n";
        for(Chips chip : chips){
            summary = summary + chip.toString() + "\n";

        }
        summary = summary + String.format("Total: $%.2f\n", getTotal());
        return summary;
    }

    //getters and setters========================================================================
    // getSandwiches, getDrinks, getChips- returns the orders items
    public List<Torta> getTortas() {
        return tortas;
    }

    public void setTortas(List<Torta> tortas) {
        this.tortas = tortas;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
    }
}