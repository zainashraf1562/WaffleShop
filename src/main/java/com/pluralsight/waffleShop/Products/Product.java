package com.pluralsight.waffleShop.Products;

public abstract class Product {
    private String name;

    Product(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract double getPrice();
}
