package com.pluralsight.waffleShop.Toppings;

public class Meat extends Topping{
    public Meat(String name, String size, boolean extra) {
        super(name, size, extra);
    }

    @Override
    public double getPrice(){
        double totalPrice = 0.0;
        if (getSize().equalsIgnoreCase("small")){
            totalPrice = 1;
            if (isExtra()){
                totalPrice += 0.5;
            }
        } else if (getSize().equalsIgnoreCase("medium")) {
            totalPrice = 2;
            if (isExtra()){
                totalPrice += 1;
            }
        } else if (getSize().equalsIgnoreCase("large")) {
            totalPrice = 3;
            if (isExtra()){
                totalPrice += 1.5;
            }
        }
        return totalPrice;
    }
}
