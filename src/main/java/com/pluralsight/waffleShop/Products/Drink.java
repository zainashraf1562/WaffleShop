package com.pluralsight.waffleShop.Products;

public class Drink extends Product{
    private String size;

    public Drink(String name, String size) {
        super(name);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        double price = 0;
        if (size.equalsIgnoreCase("small")){
            price = 5;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 7;
        } else if (size.equalsIgnoreCase("large")) {
            price = 10;
        }
        return price;
    }

    @Override
    public String toString() {
        return " (" + size + ") " + getName() + " shake: $" + getPrice();
    }
}
