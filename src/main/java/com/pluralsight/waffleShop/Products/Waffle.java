package com.pluralsight.waffleShop.Products;

import com.pluralsight.waffleShop.Toppings.Chocolate;
import com.pluralsight.waffleShop.Toppings.Meat;
import com.pluralsight.waffleShop.Toppings.Topping;

import java.util.ArrayList;
import java.util.Scanner;

public class Waffle extends Product {
    private String waffleType;
    private String size;
    private ArrayList<Topping> listOfTopping;
    private boolean isCrispy;

    public Waffle(String name, String waffleType, String size, ArrayList<Topping> listOfTopping, boolean isCrispy) {
        super(name);
        this.waffleType = waffleType;
        this.size = size;
        this.listOfTopping = listOfTopping;
        this.isCrispy = isCrispy;
    }

    public String getWaffleType() {
        return waffleType;
    }

    public String getSize() {
        return size;
    }

    public boolean isCrispy() {
        return isCrispy;
    }

    public ArrayList<Topping> getListOfTopping() {
        return listOfTopping;
    }

    public void addToppings(Topping topping) {
        if (listOfTopping != null) {
            listOfTopping.add(topping);
        }
    }

    public void removeToppings(Scanner scanner) {

    }


    @Override
    public double getPrice() {
        double price = 0;

        if (size.equalsIgnoreCase("small")){
            price = 3.50;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 7.00;
        } else if (size.equalsIgnoreCase("large")) {
            price = 9.50;
        }

        for (Topping topping : listOfTopping) {
            price += topping.getPrice();
        }

        return price;

    }

    public void addMeat(Scanner scanner, Waffle waffle){

        System.out.println("Meats: ");
        System.out.println("1. Crispy Bacon");
        System.out.println("2. Turkey Bacon");
        System.out.println("3. Sausage Crumbles");
        System.out.println("4. Fried Chicken");
        System.out.println("5. Ham Slices");
        System.out.println("6. Chorizo");
        System.out.println("0. No Meat, Exit!");

        int meatChoice = scanner.nextInt();
        scanner.nextLine();

        if (meatChoice == 0){
            return;
        }

        String meatName = "";
        switch (meatChoice) {
            case 1 -> meatName = "Crispy Bacon";
            case 2 -> meatName = "Turkey Bacon";
            case 3 -> meatName = "Sausage Crumbles";
            case 4 -> meatName = "Fried Chicken";
            case 5 -> meatName = "Ham Slices";
            case 6 -> meatName = "Chorizo";
            default -> {
                System.out.println("Try Again!");;
            }
        }
        System.out.print("Do you want extra meat? (Enter 'yes' or leave blank) ");
        String extraChoice = scanner.nextLine();
        boolean wantsExtra = extraChoice.equalsIgnoreCase("yes");

        addToppings(new Meat(meatName , waffle.getSize() ,wantsExtra));
        System.out.println("Added " + meatName + "Successfully!");

    }

    public void addChocolate(Scanner scanner, Waffle waffle) {
        System.out.println("Chocolates: ");
        System.out.println("1. Reece's");
        System.out.println("2. Snickers");
        System.out.println("3. Twix");
        System.out.println("4. KitKat");
        System.out.println("5. Hershey");
        System.out.println("0. Exit");

        int chocChoice = scanner.nextInt();
        scanner.nextLine();

        if (chocChoice == 0){
            return;
        }

        String chocName = "";
        switch (chocChoice) {
            case 1 -> chocName = "Reece's";
            case 2 -> chocName = "Snickers";
            case 3 -> chocName = "Twix";
            case 4 -> chocName = "KitKat";
            case 5 -> chocName = "Hershey";
            default -> {
                System.out.println("Try Again!");;
            }
        }
        System.out.print("Do you want extra chocolate? (Enter 'yes' or leave blank) ");
        String extraChoice = scanner.nextLine();
        boolean wantsExtra = extraChoice.equalsIgnoreCase("yes");

        addToppings(new Chocolate(chocName , waffle.getSize() ,wantsExtra));
        System.out.println("Added " + chocChoice + "Successfully!");
    }

}