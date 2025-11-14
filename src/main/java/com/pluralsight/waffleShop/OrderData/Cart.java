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

    public double getTotalCost(){
        double sum = 0;

        for (Product product : myCart) {
            sum += product.getPrice();
        }
        return sum;
    }

}
