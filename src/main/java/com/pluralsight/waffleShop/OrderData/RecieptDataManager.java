package com.pluralsight.waffleShop.OrderData;

import com.pluralsight.waffleShop.Products.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecieptDataManager {
    public void saveReceipt(Cart cart){
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = "receipts/" + timeNow.format(formatter) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("======== DELI-BROS ========\n");
            writer.write("  THANK YOU FOR SHOPPING!\n");
            writer.write("===========================\n");

            DateTimeFormatter receiptFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
            writer.write("DATE: " + timeNow.format(receiptFormatter) + "\n\n");

            writer.write("ITEMS:\n");
            writer.write("---------------------------\n");

            for (Product product : cart.getMyCart()) {
                writer.write(product.toString() + "\n");
            }

            writer.write("\n---------------------------\n");
            writer.write("TOTAL: $" + String.format("%.2f", cart.getTotalCost()) + "\n");
            writer.write("===========================\n");
            writer.write("        COME AGAIN!        \n");
            writer.write("===========================\n");

        } catch (Exception ex) {
            System.err.println("Error Saving File");
        }
    }

}
