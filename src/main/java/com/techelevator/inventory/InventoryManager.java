package com.techelevator.inventory;

import com.techelevator.Constants;
import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
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

        // Read from inventoryFile and set inventory
        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(","); // example {A1, U-Chews, 1.65, Gum}
                String slotLocation = array[0];
                String productName = array[1];
                BigDecimal price = new BigDecimal(array[2]);
                String productType = array[3];
                Item productToAdd = null;
                switch (productType) {
                    case DRINK:
                        productToAdd = new Drink(productName, price);
                        break;
                    case GUM:
                        productToAdd = new Gum(productName, price);
                        break;
                    case MUNCHY:
                        productToAdd = new Munchy(productName, price);
                        break;
                    case CANDY:
                        productToAdd = new Candy(productName, price);
                        break;
                }

                inventory.add(new Slot(slotLocation, productToAdd));

            }
        } catch (FileNotFoundException e) {
            System.out.println("There was an error starting up the vending machine. Please try again later.");
        }
    }

    public boolean dispenseInventory(Slot slot) {
        int productRemaining = slot.getProductRemaining();
        if (productRemaining == 0) {
            return false; // no item to dispense, so don't try to dispense
        }
        slot.setProductRemaining(slot.getProductRemaining() - 1);
        return true; // product successfully dispensed and slot.productRemaining was successfully decremented
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
