package com.pluralsight.waffleShop.Products;

import com.pluralsight.waffleShop.Toppings.Chocolate;
import com.pluralsight.waffleShop.Toppings.Fruit;
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
                System.out.println("Try Again!");
                return;
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
                System.out.println("Try Again!");
                return;
            }
        }
        System.out.print("Do you want extra chocolate? (Enter 'yes' or leave blank) ");
        String extraChoice = scanner.nextLine();
        boolean wantsExtra = extraChoice.equalsIgnoreCase("yes");

        addToppings(new Chocolate(chocName , waffle.getSize() ,wantsExtra));
        System.out.println("Added " + chocName + "Successfully!");
    }

    public void addFruit(Scanner scanner, Waffle waffle) {
        System.out.println("Fruits: ");
        System.out.println("1. Strawberries");
        System.out.println("2. Blueberries");
        System.out.println("3. Raspberries");
        System.out.println("4. Blackberries");
        System.out.println("5. Mango");
        System.out.println("6. Peach");
        System.out.println("7. Kiwi");
        System.out.println("8. Banana");
        System.out.println("9. Pineapple");
        System.out.println("0. Exit");

        int fruitChoice = scanner.nextInt();
        scanner.nextLine();

        if (fruitChoice == 0){
            return;
        }

        String fruitName = "";
        switch (fruitChoice) {
            case 1 -> fruitName = "Strawberries";
            case 2 -> fruitName = "Blueberries";
            case 3 -> fruitName = "Raspberries";
            case 4 -> fruitName = "Blackberries";
            case 5 -> fruitName = "Mango";
            case 6 -> fruitName = "Peach";
            case 7 -> fruitName = "Kiwi";
            case 8 -> fruitName = "Banana";
            case 9 -> fruitName = "Pineapple";
            default -> {
                System.out.println("Try Again!");
                return;
            }
        }
        System.out.print("Do you want extra fruit? (Enter 'yes' or leave blank) ");
        String extraChoice = scanner.nextLine();
        boolean wantsExtra = extraChoice.equalsIgnoreCase("yes");

        addToppings(new Fruit(fruitName ,wantsExtra));
        System.out.println("Added " + fruitName + "Successfully!");
    }

    public void addSyrup(Scanner scanner, Waffle waffle) {
        System.out.println("Syrups: ");
        System.out.println("1. Maple Syrup");
        System.out.println("2. Chocolate Syrup");
        System.out.println("3. Caramel Syrup");
        System.out.println("4. Blueberry Syrup");
        System.out.println("5. Strawberry Syrup");
        System.out.println("0. Exit");

        int syrupChoice = scanner.nextInt();
        scanner.nextLine();

        if (syrupChoice == 0){
            return;
        }

        String syrupName = "";
        switch (syrupChoice) {
            case 1 -> syrupName = "Maple Syrup";
            case 2 -> syrupName = "Chocolate Syrup";
            case 3 -> syrupName = "Caramel Syrup";
            case 4 -> syrupName = "Blueberry Syrup";
            case 5 -> syrupName = "Strawberry Syrup";
            default -> {
                System.out.println("Try Again!");
                return;
            }
        }
        System.out.print("Do you want extra syrup? (Enter 'yes' or leave blank) ");
        String extraChoice = scanner.nextLine();
        boolean wantsExtra = extraChoice.equalsIgnoreCase("yes");

        addToppings(new Fruit(syrupName,wantsExtra));
        System.out.println("Added " + syrupName + "Successfully!");
    }

    public void addSide(Scanner scanner, Waffle waffle) {
        System.out.println("Sides: ");
        System.out.println("1. Fries");
        System.out.println("2. Scrambled Eggs");
        System.out.println("0. Exit");

        int sideChoice = scanner.nextInt();
        scanner.nextLine();

        if (sideChoice == 0){
            return;
        }

        String sideName = "";
        switch (sideChoice) {
            case 1 -> sideName = "Fries";
            case 2 -> sideName = "Scrambled Eggs";
            default -> {
                System.out.println("Try Again!");
                return;
            }
        }
        System.out.print("Do you want extra sides? (Enter 'yes' or leave blank) ");
        String extraChoice = scanner.nextLine();
        boolean wantsExtra = extraChoice.equalsIgnoreCase("yes");

        addToppings(new Fruit(sideName,wantsExtra));
        System.out.println("Added " + sideName + "Successfully!");
    }

    public void setWaffleType(Scanner scanner, Waffle waffle) {
        System.out.println("Waffle Types: ");
        System.out.println("1. Belgian");
        System.out.println("2. Chocolate Chip");
        System.out.println("3. Cinnamon");
        System.out.println("4. Buttermilk");
        System.out.println("0. Exit");

        int sideChoice = scanner.nextInt();
        scanner.nextLine();

        if (sideChoice == 0){
            return;
        }

        String sideName = "";
        switch (sideChoice) {
            case 1 -> sideName = "Belgian";
            case 2 -> sideName = "Chocolate Chip";
            case 3 -> sideName = "Cinnamon";
            case 4 -> sideName = "Classic Buttermilk";
            default -> {
                System.out.println("Try Again!");
                return;
            }
        }
        waffleType = sideName;
    }

    public String toString() {
        String base = "Waffle: " + size + " " + waffleType + " Waffle - $" + getPrice();

        if (listOfTopping.isEmpty()) {
            return base + "\n[ No Toppings ]";
        }

        String line = "";
        for (int i = 0; i < listOfTopping.size(); i++) {
            Topping topping = listOfTopping.get(i);
            line += "- " + topping.toString() + "\n";
        }

        return base + "\nToppings:\n" + line.trim();
    }


}