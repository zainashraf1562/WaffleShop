package com.pluralsight.waffleShop.UserInterface;

import com.pluralsight.waffleShop.OrderData.Cart;
import com.pluralsight.waffleShop.OrderData.ReceiptDataManager;
import com.pluralsight.waffleShop.Products.MilkShake;
import com.pluralsight.waffleShop.Products.Icecream;
import com.pluralsight.waffleShop.Products.SignatureWaffles.ClassicWaffle;
import com.pluralsight.waffleShop.Products.SignatureWaffles.SpecialWaffle;
import com.pluralsight.waffleShop.Products.Waffle;

import java.util.Scanner;

public class Home {
    private Scanner scanner = new Scanner(System.in);
    private Cart myCart;

    public static final String reset = "\u001B[0m";
    public static final String green = "\u001B[32m";
    public static final String red = "\u001B[31m";



    public void homeScreen(){

        while (true){
            System.out.println(
                            "╔═════════════════════════════════════════════╗\n" +
                            "║              🍨 WAFFLE SHOP 🧇              ║\n" +
                            "╠═════════════════════════════════════════════╣\n" +
                            "║   Welcome to the Waffle & Ice Cream Heaven! ║\n" +
                            "║                                             ║\n" +
                            "║   👉 1. Start a New Order                   ║\n" +
                            "║   👉 0. Exit                                ║\n" +
                            "╚═════════════════════════════════════════════╝"
            );


            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1:
                    orderMenu();
                    break;
                case 0:
                    System.out.println(green + "GoodBye!!" + reset);
                    return;
                default:
                    System.out.println(red + "Invalid Input, Try Again" + reset);
            }
        }
    }

    public void orderMenu(){
        myCart = new Cart();
        boolean quit = false;

        while(!quit){
            System.out.println(
                            "╔═══════════════════════ WAFFLE SHOP MENU ════════════════════╗\n" +
                            "║   🧇 1. Waffles                                             ║\n" +
                            "║   🍨 2. Ice Cream                                           ║\n" +
                            "║   🥤 3. Milkshake                                           ║\n" +
                            "║   🛒 4. Current Shopping Cart                               ║\n" +
                            "║   💵 5. Checkout                                            ║\n" +
                            "║   ❌ 0. Cancel Order                                        ║\n" +
                            "╚═════════════════════════════════════════════════════════════╝"
            );


            int userInput2 = scanner.nextInt();
            scanner.nextLine();

            switch (userInput2){
                case 1:
                    addWaffle();
                    break;
                case 2:
                    addIceCream();
                    break;
                case 3:
                    addMilkShake();
                    break;
                case 4:
                    myCart.showMyCart();
                    break;
                case 5:
                    checkout();
                    myCart.emptyMyCart();
                    quit = true;
                    break;
                case 0:
                    quit = true;
                    System.out.println(green + "Order Canceled" + reset);
                    break;
                default:
                    System.out.println(red + "Enter a Valid Input" + reset);
            }
        }
    }

    private void addWaffle() {
        System.out.println(
                        "╔═══════════════════ WAFFLE TYPE ═══════════════════╗\n" +
                        "║   1. Make Your Own Waffle                         ║\n" +
                        "║   2. Signature Waffle                             ║\n" +
                        "║   0. Cancel                                       ║\n" +
                        "╚═══════════════════════════════════════════════════╝"
        );

        int input = scanner.nextInt();
        scanner.nextLine();
        String userInputType = "";
        switch (input){
            case 1 -> userInputType = "Make Your Own Waffle";
            case 2 -> userInputType = "Signature Waffle";
            default -> System.out.println(red + "Invalid Input, Try again!" + reset);
        }

        Waffle newWaffle = null;
        if (input == 1) {
            System.out.println(
                            "╔══════════════════ WAFFLE SIZE ═════════════════╗\n" +
                            "║   1. Small                                     ║\n" +
                            "║   2. Medium                                    ║\n" +
                            "║   3. Large                                     ║\n" +
                            "╚════════════════════════════════════════════════╝"
            );

            int size = scanner.nextInt();
            scanner.nextLine();

            String waffleSize = "";
            switch (size) {
                case 1 -> waffleSize = "small";
                case 2 -> waffleSize = "medium";
                case 3 -> waffleSize = "large";
                default -> {
                    System.out.println(red + "Invalid Input, Try again!" + reset);
                    return;
                }
            }

            System.out.println(
                            "╔══════════════════════ WAFFLE TYPE ════════════════════╗\n" +
                            "║   1. Belgian                                          ║\n" +
                            "║   2. Chocolate                                        ║\n" +
                            "║   3. Cinnamon                                         ║\n" +
                            "║   4. Buttermilk                                       ║\n" +
                            "║   0. Back                                             ║\n" +
                            "╚═══════════════════════════════════════════════════════╝"
            );

            int input09 = scanner.nextInt();
            scanner.nextLine();

            String waffleType = "";
            switch (input09) {
                case 1 -> waffleType = "Belgian";
                case 2 -> waffleType = "Chocolate";
                case 3 -> waffleType = "Cinnamon";
                case 4 -> waffleType = "Buttermilk";
                case 0 -> {
                    System.out.println(green + "Menu..." + reset);
                    return;
                }
                default -> {
                    System.out.println(red + "Invalid Input, Try again!" + reset);
                    return;
                }
            }

            System.out.print("Do you want it crispy? Enter yes or leave blank: ");
            String stuffedHolder = scanner.nextLine();
            boolean isCrispy = stuffedHolder.equalsIgnoreCase("yes");

            newWaffle = new Waffle("Custom Waffle", waffleType, waffleSize, isCrispy);

            addTopping(newWaffle);
            System.out.println(green + "Added Custom Waffle Successfully!" + reset);

        } else if (input == 2) {
            System.out.println(
                            "╔══════════════ SIGNATURE WAFFLES ══════════════╗\n" +
                            "║   1. Classic Waffle                           ║\n" +
                            "║   2. Special Waffle                           ║\n" +
                            "║   0. Cancel                                   ║\n" +
                            "╚═══════════════════════════════════════════════╝"
            );


            int input2 = scanner.nextInt();
            scanner.nextLine();

            switch (input2) {
                case 1 -> newWaffle = new ClassicWaffle();
                case 2 -> newWaffle = new SpecialWaffle();
                case 0 -> { return; }
                default -> {
                    System.out.println(red + "Invalid Input, Try Again" + reset);
                    return;
                }
            }

            addTopping(newWaffle);
            System.out.println(green + "Added Signature Waffle Successfully"  + reset);
        }
        myCart.addProduct(newWaffle);

    }

    private void addTopping(Waffle newWaffle) {
        while(true) {
            System.out.println(
                            "╔════════════════════ TOPPINGS MENU ═══════════════════╗\n" +
                            "║   1. Meats                                           ║\n" +
                            "║   2. Chocolates                                      ║\n" +
                            "║   3. Fruits                                          ║\n" +
                            "║   4. Syrups                                          ║\n" +
                            "║   5. Sides                                           ║\n" +
                            "║   6. Remove Topping                                  ║\n" +
                            "║   0. Cancel                                          ║\n" +
                            "╚══════════════════════════════════════════════════════╝"
            );

            int userInput3 = scanner.nextInt();
            scanner.nextLine();

            switch (userInput3) {
                case 1 -> newWaffle.addMeat(scanner,newWaffle);
                case 2 -> newWaffle.addChocolate(scanner,newWaffle);
                case 3 -> newWaffle.addFruit(scanner,newWaffle);
                case 4 -> newWaffle.addSyrup(scanner,newWaffle);
                case 5 -> newWaffle.addSide(scanner,newWaffle);
                case 6 -> newWaffle.removeToppings(scanner);
                case 0 -> {
                    return;
                }
                default -> System.out.println(red + "Invalid Input, Try Again!" + reset);
            }
        }
    }

    private void addIceCream() {
        while (true) {
            System.out.println(
                            "╔════════════════════ ICE CREAM MENU ════════════════════╗\n" +
                            "║   1. Vanilla                                           ║\n" +
                            "║   2. Chocolate                                         ║\n" +
                            "║   3. Cookie Dough                                      ║\n" +
                            "║   0. Back                                              ║\n" +
                            "╚════════════════════════════════════════════════════════╝"
            );

            int input4 = scanner.nextInt();
            scanner.nextLine();

            switch (input4) {
                case 1 -> myCart.addProduct(new Icecream("Vanilla"));
                case 2 -> myCart.addProduct(new Icecream("Chocolate"));
                case 3 -> myCart.addProduct(new Icecream("Cookie Dough"));
                case 0 -> System.out.println(green + "Menu..." + reset);
                default -> {
                    System.err.println(red + "Invalid Input, Try Again!" + reset);
                    continue;
                }
            }
            System.out.println(green + "Added IceCream Successfully!" + reset);
            return;
        }

    }

    private void addMilkShake() {
        System.out.println(
                        "╔════════════════════ MILKSHAKE MENU ═══════════════════╗\n" +
                        "║   1. Vanilla                                           ║\n" +
                        "║   2. Chocolate                                         ║\n" +
                        "║   3. Chocolate Chip                                    ║\n" +
                        "║   0. Back                                              ║\n" +
                        "╚════════════════════════════════════════════════════════╝"
        );


        int input5 = scanner.nextInt();
        scanner.nextLine();


        String drinkName = "";
        switch (input5) {
            case 1 -> drinkName = "Vanilla";
            case 2 -> drinkName = "Chocolate";
            case 3 -> drinkName = "Chocolate Chip";
            case 0 -> {
                System.out.println(green + "Menu..." + reset);
                return;
            }
            default -> {
                System.out.println(red+ "Invalid Input, Try again!" + reset);
                return;
            }
        }

        System.out.println(
                        "╔══════════════════ DRINK SIZE ══════════════════╗\n" +
                        "║   1. Small                                     ║\n" +
                        "║   2. Medium                                    ║\n" +
                        "║   3. Large                                     ║\n" +
                        "╚════════════════════════════════════════════════╝"
        );

        int size = scanner.nextInt();
        scanner.nextLine();

        String shakeSize = "";
        switch (size) {
            case 1 -> shakeSize = "small";
            case 2 -> shakeSize = "medium";
            case 3 -> shakeSize = "large";
            default -> {
                System.out.println(red + "Invalid Input, Try again!" + reset);
                return;
            }
        }

        MilkShake drink = new MilkShake(drinkName, shakeSize);
        myCart.addProduct(drink);
        System.out.println(green + "Added Drink Successfully!"+ reset);
    }

    private void checkout() {
        System.out.println(
                "╔══════════════════════ CHECKOUT ══════════════════════╗"
        );

        if (myCart.getMyCart().isEmpty()){
            System.out.println(red + "You have no items in this order"+ reset);
            return;
        }

        myCart.showMyCart();

        System.out.println("Confirm Order? (Yes/No)");
        String input6 = scanner.nextLine();

        if (input6.equalsIgnoreCase("yes")){
            ReceiptDataManager receiptDataManager = new ReceiptDataManager();
            receiptDataManager.saveReceipt(myCart);
            System.out.println(green + "Order successfully placed"+ reset);
        } else {
            System.out.println(red+ "Order Canceled!"+ reset);
        }
    }

}
