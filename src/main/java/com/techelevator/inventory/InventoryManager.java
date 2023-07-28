package com.techelevator.inventory;

import com.techelevator.Items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class InventoryManager {
//    private Map<Slot, Item> inventory = new HashMap<>();
//    private Set<Slot> inventory = new HashSet<>();
    private List<Slot> inventory = new ArrayList<>();

    public InventoryManager() {
        File inventoryFile = new File("main.csv");
        final String DRINK = "Drink";
        final String GUM = "Gum";
        final String MUNCHY = "Munchy";
        final String CANDY = "Candy";

        // setInventory
        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(",");
                // example {A1,U-Chews,1.65,Gum}
                String slotLocation = array[0];
                String productName = array[1];
                BigDecimal price = new BigDecimal(array[2]);
                String productType = array[3];
                Item productToAdd = null;
                switch (productType) {
                    case DRINK:
                        productToAdd = new Drink(productName, productType, price);
                        break;
                    case GUM:
                        productToAdd = new Gum(productName, productType, price);
                        break;
                    case MUNCHY:
                        productToAdd = new Munchy(productName, productType, price);
                        break;
                    case CANDY:
                        productToAdd = new Candy(productName, productType, price);
                        break;
                }
//                inventory.put(new Slot(slotLocation, productToAdd), productToAdd); // todo: should it be a map, a set, or just a String with the location?
                inventory.add(new Slot(slotLocation, productToAdd));

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // dispense/remove from inventory
    public void dispenseInventory(Slot slot)
    {
        slot.setProductRemaining(slot.getProductRemaining()-1);
    }




    public List<Slot> getInventory() {
        return inventory;
    }
}
