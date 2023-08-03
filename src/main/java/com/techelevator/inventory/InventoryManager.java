package com.techelevator.inventory;

import com.techelevator.Constants;
import com.techelevator.items.*;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private final List<Slot> inventory = new ArrayList<>();

    public InventoryManager(String pathName) {
        File inventoryFile = new File(pathName);
        final String DRINK = Constants.DRINK;
        final String GUM = Constants.GUM;
        final String MUNCHY = Constants.MUNCHY;
        final String CANDY = Constants.CANDY;

        // Read from inventoryFile (a csv file) and set inventory
        try (Scanner scanner = new Scanner(inventoryFile)) {
            int lineCount = 0; // Kept track of for error logging purposes
            while (scanner.hasNextLine()) {
                lineCount++;
                String line = scanner.nextLine();
                String[] array = line.split(Constants.INVENTORY_FILE_FIELD_DELIMITER);
                // example {"A1", "U-Chews", "1.65", "Gum"}

                // ########################################## START PRELIMINARY VALIDATION CHECKS ######################
                if (array.length != 4) {
                    continue; // TODO: add a log item here with the line that wasn't added
                }
                // ****************************************** set and validate slot location ***************************
                String slotLocation = array[0];
                if (!slotLocation.matches(Constants.PRODUCT_CODE_REGEX_EXPRESSION)) {
                    continue; // TODO: add a log item here with the line that wasn't added
                }
                // ****************************************** set and validate product name ****************************
                String productName = array[1];
                if (productName.isBlank()) {
                    continue; // TODO: add a log item here with the line that wasn't added
                }
                // ****************************************** set and validate price ***********************************
                BigDecimal price;
                try {
                    price = new BigDecimal(array[2]).setScale(2, RoundingMode.HALF_UP);
                } catch (NumberFormatException e) {
                    continue; // TODO: add a log item here with the line that wasn't added
                }
                // ****************************************** set and validate product type ****************************
                String productType = array[3];
                if (Arrays.stream(Constants.ITEM_TYPE_ARRAY).noneMatch(productType::equalsIgnoreCase)) {
                    continue; // TODO: add a log item here with the line that wasn't added
                }
                // ########################################## FINISH PRELIMINARY VALIDATION CHECKS #####################

                Item productToAdd;
                if (productType.equalsIgnoreCase(DRINK)) {
                    productToAdd = new Drink(productName, price);
                } else if (productType.equalsIgnoreCase(GUM)) {
                    productToAdd = new Gum(productName, price);
                } else if (productType.equalsIgnoreCase(MUNCHY)) {
                    productToAdd = new Munchy(productName, price);
                } else if (productType.equalsIgnoreCase(CANDY)) {
                    productToAdd = new Candy(productName, price);
                } else {
                    productToAdd = null;
                }

                // ########################################## FINAL VALIDATION CHECK ###################################
                if (productToAdd == null) {
                    continue; // TODO: add a log item here with the line that wasn't added
                }

                inventory.add(new Slot(slotLocation, productToAdd));
            }
        } catch (FileNotFoundException e) {
            System.out.println("There was an error starting up the vending machine. Please try again later.");
        } // TODO: figure out what to do about errors, and make sure all sout statements are in print manager
    }

    public boolean dispenseInventory(Slot slot) {
        return slot.decrementProductRemaining();
        // true -> if there was product to dispense and product count was successfully decremented
        // false -> if there was no product left to dispense
    }

    public List<Slot> getInventory() {
        return inventory;
    }

    public String[] getInventoryOptionsAsDisplayStringArray() {
        String[] inventoryOptionsArray = new String[inventory.size()];
        for (int i = 0; i < inventory.size(); i++) {
            Slot slot = inventory.get(i);

            String location = slot.getLocation();
            Item product = slot.getProductInSlot();
            BigDecimal price = product.getPrice();
            int productRemaining = slot.getProductRemaining();
            String productName = product.getProductName();

            String option = location
                    + "  $"
                    + price
                    + "  "
                    + "Remaining: "
                    +
                    (
                            productRemaining == 0
                                    ? "SOLD OUT "
                                    : productRemaining + " ".repeat("SOLD OUT ".length() - String.valueOf(productRemaining).length())
                    )
                    + productName;

            inventoryOptionsArray[i] = option;
        }
        return inventoryOptionsArray;
    }
}
