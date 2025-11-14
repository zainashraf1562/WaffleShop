package com.pluralsight.waffleShop.Products;

public class Icecream extends Product{
    public Icecream(String name){
        super(name);
    }

    @Override
    public double getPrice() {
        return 2.0;
    }

    @Override
    public String toString() {
        return getName() + " IceCream: $" + getPrice();
    }


}
