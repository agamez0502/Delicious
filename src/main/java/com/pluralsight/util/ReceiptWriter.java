package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        // generate filename using current date/time (yyyyMMdd-hhmmss.txt)
        // create a FileWriter and wrap in BufferedWriter (src/main/resources/receipts)

        // loop through all order items
        //   - write the items to the to reciept

        //write total cost

        // close BufferedWriter
        // handle IOException with error message
    }

    private static String generateTimestamp() {
        // Create timestamp string useing a formatter
        // return that string
    }

    // Format 5: 2023-09-06 12:42:20
    DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    // Current date and time
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now.format(formatter5));
}