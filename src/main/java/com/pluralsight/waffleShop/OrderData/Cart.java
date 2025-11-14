package com.pluralsight.waffleShop.OrderData;

import com.pluralsight.waffleShop.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final String blue = "\u001B[34m";
    public static final String reset = "\u001B[0m";
    private List<Product> myCart;

    public Cart(){
        myCart = new ArrayList<>();
    }

    public List<Product> getMyCart() {
        return myCart;
    }

    public void addProduct(Product product){
        myCart.add(product);
    }

    public void emptyMyCart(){
        myCart.clear();
    }

    public void showMyCart() {
        if (getMyCart().isEmpty()) {
            System.out.println(blue + "[ Empty Cart ]" + reset);
            return;
        }

        System.out.println(blue+ "=== MY CART ===\n");

        for (Product product : myCart) {
            System.out.println(product);
            System.out.println("-----------------------");
        }

        System.out.println("\nTotal: $" + String.format("%.2f", getTotalCost()) + reset);
    }


    public double getTotalCost(){
        double sum = 0;

        for (Product product : myCart) {
            sum += product.getPrice();
        }
        return sum;
    }

}
