package com.pluralsight.waffleShop.UserInterface;

import com.pluralsight.waffleShop.OrderData.Cart;
import com.pluralsight.waffleShop.OrderData.ReceiptDataManager;
import com.pluralsight.waffleShop.Products.Drink;
import com.pluralsight.waffleShop.Products.Icecream;
import com.pluralsight.waffleShop.Products.SignatureWaffles.ClassicWaffle;
import com.pluralsight.waffleShop.Products.SignatureWaffles.SpecialWaffle;
import com.pluralsight.waffleShop.Products.Waffle;

import java.util.Scanner;

public class Home {
    private Scanner scanner = new Scanner(System.in);
    private Cart myCart;

    public void homeScreen(){

        while (true){
            System.out.println(
                    "🧇🧇🧇  WELCOME TO WAFFLE SHOP!  🧇🧇🧇\n" +
                            "---------------------------------------\n" +
                            "   1 ➤ Start New Order\n" +
                            "   0 ➤ Exit\n" +
                            "---------------------------------------\n"
            );

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1:
                    orderMenu();
                    break;
                case 0:
                    System.out.println("GoodBye!!");
                    return;
                default:
                    System.out.println("Wrong Input, Try Again");
            }
        }
    }

    public void orderMenu(){
        myCart = new Cart();
        boolean quit = false;

        while(!quit){
            System.out.println(
                            "🍦🍨🍧 WELCOME TO THE WAFFLE HOUSE MENU 🍧🍨🍦\n" +
                            "----------------------------------------------------\n" +
                            "   1 ➤ Waffles 🧇\n" +
                            "   2 ➤ IceCream 🍨\n" +
                            "   3 ➤ MilkShake 🥤\n" +
                            "   4 ➤ CheckOut 🛒\n" +
                            "   0 ➤ Cancel Order ❌\n" +
                            "----------------------------------------------------\n"
            );


            System.out.print("Your Choice: ");

            int userInput2 = scanner.nextInt();
            scanner.nextLine();

            switch (userInput2){
                case 1:
                    addWaffle();
                    break;
                case 2:
                    addMilkShake();
                    break;
                case 3:
                    addIceCream();
                    break;
                case 4:
                    checkout();
                    myCart.emptyMyCart();
                    break;
                case 0:
                    quit = true;
                    System.out.println("Order Canceled");
                    break;
                default:
                    System.out.println("Enter Valid Input");
            }
        }
    }

    private void addWaffle() {
        System.out.println("Enter Waffle Type");
        System.out.println("1. Make Your Own Waffle");
        System.out.println("2. Signature Waffle");
        int input = scanner.nextInt();
        scanner.nextLine();
        String waffleType = "";
        switch (input){
            case 1 -> waffleType = "Make Your Own Waffle";
            case 2 -> waffleType = "Signature Waffle";
            default -> System.out.println("Invalid, Try again!");
        }

        Waffle newWaffle = null;
        if (input == 1) {
            waffleType = "Custom Waffle";
            System.out.print("Enter Size (small,medium,large): ");
            String waffleSize = scanner.nextLine();

            System.out.print("Enter Waffle Type (Belgian,Chocolate,Cinnamon,Buttermilk): ");
            String pizzaType = scanner.nextLine();

            System.out.print("Do you want it crispy? Enter yes or leave blank: ");
            String stuffedHolder = scanner.nextLine();
            boolean isCrispy = stuffedHolder.equalsIgnoreCase("yes");

            newWaffle = new Waffle("Custom Waffle", waffleType, waffleSize, isCrispy);

            addTopping(newWaffle);
            myCart.addProduct(newWaffle);
            System.out.println("Added Custom Waffle Successfully!");

        } else if (input == 2) {
            System.out.println("Choose a Signature Waffle:");
            System.out.println("1. Classic Waffle");
            System.out.println("2. Special Waffle");
            System.out.println("0. Cancel");

            int input2 = scanner.nextInt();
            scanner.nextLine();

            switch (input2) {
                case 1 -> newWaffle = new ClassicWaffle();
                case 2 -> newWaffle = new SpecialWaffle();
                case 0 -> { return; }
                default -> {
                    System.out.println("Invalid, Try-Again");
                    return;
                }
            }

            addTopping(newWaffle);
            System.out.println("Signature Pizza Added");
        }

        myCart.addProduct(newWaffle);
        System.out.println("Added Pizza Successfully");
    }

    private void addTopping(Waffle newWaffle) {
        while(true) {
            System.out.println("TOPPINGS");
            System.out.println("Enter: ");
            System.out.println("1. Meats");
            System.out.println("2. Chocolates");
            System.out.println("3. Fruits");
            System.out.println("4. Syrups");
            System.out.println("4. Sides");
            System.out.println("5. Remove Topping");
            System.out.println("0. Done..");
            int userInput3 = scanner.nextInt();
            scanner.nextLine();
            if (userInput3 == 0) {
                return;
            }
            switch (userInput3) {
                case 1 -> newWaffle.addMeat(scanner,newWaffle);
                case 2 -> newWaffle.addChocolate(scanner,newWaffle);
                case 3 -> newWaffle.addFruit(scanner,newWaffle);
                case 4 -> newWaffle.addSyrup(scanner,newWaffle);
                case 5 -> newWaffle.addSide(scanner,newWaffle);
                case 6 -> newWaffle.removeToppings(scanner);
                default -> System.out.println("Invalid Input, Try Again!");
            }
        }
    }

    private void addIceCream() {
        while (true) {
            System.out.println("ICECREAM");
            System.out.println("Enter: ");
            System.out.println("1. Vanilla");
            System.out.println("2. Chocolate");
            System.out.println("3. Cookie Dough");
            System.out.println("0. Exit");
            int input4 = scanner.nextInt();
            scanner.nextLine();

            switch (input4) {
                case 1 -> myCart.addProduct(new Icecream("Vanilla"));
                case 2 -> myCart.addProduct(new Icecream("Chocolate"));
                case 3 -> myCart.addProduct(new Icecream("Cookie Dough"));
                case 0 -> System.out.println("Menu...");
                default -> {
                    System.err.println("Invalid, Try Again!");
                    continue;
                }
            }
            return;
        }

    }

    private void addMilkShake() {
        System.out.println("DRINK");
        System.out.println("Enter: ");
        System.out.println("1. Vanilla");
        System.out.println("2. Chocolate");
        System.out.println("1. Chocolate Chip");

        int input5 = scanner.nextInt();
        scanner.nextLine();


        String drinkName = "";
        switch (input5) {
            case 1 -> drinkName = "Coke";
            case 2 -> drinkName = "Pepsi";
            case 3 -> drinkName = "Water";
            case 0 -> {
                System.out.println("Menu...");
                return;
            }
            default -> {
                System.out.println("Invalid, Try again!");
                return;
            }
        }

        System.out.println("Enter size:");
        System.out.println("1. Small | 2. Medium | 3. Large");
        int size = scanner.nextInt();
        scanner.nextLine();

        String shakeSize = "";
        switch (size) {
            case 1 -> shakeSize = "small";
            case 2 -> shakeSize = "medium";
            case 3 -> shakeSize = "large";
            default -> {
                System.out.println("Invalid , Try again!");
                return;
            }
        }

        Drink drink = new Drink(drinkName, shakeSize);
        myCart.addProduct(drink);
        System.out.println("Successfully added drink!");
    }

    private void checkout() {
        System.out.println("Check Out");

        if (myCart.getMyCart().isEmpty()){
            System.out.println("You have no items in this order");
            return;
        }

        myCart.showMyCart();

        double total = myCart.getTotalCost();
        System.out.println("Total Cost: " + total);
        System.out.println("Confirm Order? (Yes/No)");
        String input6 = scanner.nextLine();

        if (input6.equalsIgnoreCase("yes")){
            ReceiptDataManager receiptDataManager = new ReceiptDataManager();
            receiptDataManager.saveReceipt(myCart);
            System.out.println("Order successfully placed");
        } else {
            System.out.println("Order Canceled!");
        }
    }

}
