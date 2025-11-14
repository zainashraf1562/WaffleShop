package com.pluralsight.waffleShop.Toppings;

public abstract class Topping {
    private String name;
    private String size;
    private boolean isExtra;

    public Topping(String name, boolean extra){
        this.name = name;
        isExtra = extra;
    }

    public Topping(String name, String size, boolean extra){
        this.name = name;
        this.size = size;
        isExtra = extra;
    }

    public double getPrice(){
        return 0.0;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public boolean isExtra() {
        return isExtra;
    }
}
