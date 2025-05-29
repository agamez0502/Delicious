package com.pluralsight.models;

public class Toppings {

    //properties=================================================================================
    private String name;
    private String type;
    private boolean isExtra;

    //constructor================================================================================
    public Toppings(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type;
        this.isExtra = isExtra;
    }

    //methods====================================================================================
    @Override
    public String toString() {
        if (isExtra && (type.equalsIgnoreCase("protein") || type.equalsIgnoreCase("cheese"))) {
            return name + " (extra)";
        } else {
            return name;
        }
    }

    //getters and setters========================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }
}