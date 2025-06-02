package com.pluralsight.models;

public class ToppingSelection {

    //properties=================================================================================
    private String name;
    private boolean isExtra;

    //constructor================================================================================
    public ToppingSelection(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    //methods====================================================================================
    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }

    //getters and setters========================================================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }
}