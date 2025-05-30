package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order) {

        File folder = new File("src/main/resources/receipts");

        //generate filename using current date/time (yyyyMMdd-hhmmss.txt)
        String fileName = generateTimestamp() + ".txt";
        File receiptFile = new File(folder, fileName);

        try {
            //create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts)
            FileWriter fileWriter = new FileWriter(receiptFile);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);

            //header for receipt
            buffWriter.write("Torta-Licious Order Receipt \uD83E\uDDFE\n");
            buffWriter.write("═════════════════════════════════\n");

            //formatting
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            buffWriter.write("Date: " + LocalDateTime.now().format(formatter) + "\n\n");

            //write total cost
            //loop through all order items and write the items to the to receipt
            buffWriter.write(order.getOrderSummary());

            //close BufferedWriter
            buffWriter.close();
            System.out.println("Receipt saved to: " + receiptFile.getPath() + " ✅");

            //handle exception with error message
        } catch (Exception e) {
            System.out.println("Error saving receipt: " + e.getMessage() + " ❌");
        }

    }

    private static String generateTimestamp() {
        //Create timestamp string using a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //return that format
        return now.format(formatter);
    }
}