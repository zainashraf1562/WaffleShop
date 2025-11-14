package com.pluralsight.waffleShop.OrderData;

import com.pluralsight.waffleShop.Products.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptDataManager {
    public void saveReceipt(Cart cart){
        try {
        if (cart == null) {
            System.out.println("Order was null. Cannot save receipt.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String time = now.format(formatter);

        String fileName = "receipt." + time + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write("======== WAFFLE SHOP ========\n");
            writer.write("  THANK YOU FOR SHOPPING! \n");
            writer.write("===========================\n");

            writer.write("DATE: " + time + "\n\n");

            writer.write("ITEMS:\n");
            writer.write("---------------------------\n");

        for (Product product : cart.getMyCart()) {
            writer.write(product.getName() + " | " + "$" + product.getPrice());
            writer.newLine();
        }

            writer.write("\n---------------------------\n");
            writer.write("TOTAL: $" + String.format("%.2f", cart.getTotalCost()) + "\n");
            writer.write("===========================\n");
            writer.write("        COME AGAIN!        \n");
            writer.write("===========================\n");
            writer.close();
            System.out.println("Receipt Saved!");

    }catch (Exception ex) {
        System.err.println("Error Saving Receipt");
    }

//        if (cart == null) {
//            System.out.println("Empty Cart!");
//            return;
//        }
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
//        String time = now.format(formatter);
//
//        String fileName = "receipt." + now + ".txt";
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//
//            writer.write("======== WAFFLE SHOP ========\n");
//            writer.write("  THANK YOU FOR SHOPPING!\n");
//            writer.write("===========================\n");
//
//            writer.write("DATE: " + time + "\n\n");
//
//            writer.write("ITEMS:\n");
//            writer.write("---------------------------\n");
//
//            for (Product product : cart.getMyCart()) {
//                writer.write(product.toString() + "\n");
//            }
//
//            writer.write("\n---------------------------\n");
//            writer.write("TOTAL: $" + String.format("%.2f", cart.getTotalCost()) + "\n");
//            writer.write("===========================\n");
//            writer.write("        COME AGAIN!        \n");
//            writer.write("===========================\n");
//            writer.close();
//            System.out.println("Receipt Saved!");
//
//        } catch (Exception ex) {
//            System.err.println("Error Saving Receipt");
//        }
    }

}
