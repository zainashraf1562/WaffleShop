package com.pluralsight.waffleShop.OrderData;

import com.pluralsight.waffleShop.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
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

    public void showMyCart(){
        if(getMyCart().isEmpty()){
            System.out.println("Empty Cart!");
            return;
        }
        System.out.println("My Cart: ");
        System.out.println();
        for (Product product : myCart) {
            System.out.println(product);
        }
        System.out.println("\nYour total is: $" + getTotalCost());

    }

    public double getTotalCost(){
        double sum = 0;

        for (Product product : myCart) {
            sum += product.getPrice();
        }
        return sum;
    }

}
