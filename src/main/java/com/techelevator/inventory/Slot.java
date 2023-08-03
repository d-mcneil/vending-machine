package com.techelevator.inventory;

import com.techelevator.Constants;
import com.techelevator.items.Item;

public class Slot {
    private final String location;
    private final Item productInSlot;
    private int productRemaining;

    public Slot(String location, Item productInSlot) {
        this.location = location;
        this.productInSlot = productInSlot;
        this.productRemaining = Constants.DEFAULT_VENDING_MACHINE_STOCK_PER_ITEM;
    }

    public boolean decrementProductRemaining() { // TODO: test method
        if (this.productRemaining == 0) {
            return false; // no item to dispense, so don't decrement count
        }
        this.productRemaining--;
        // product successfully dispensed and this.productRemaining was successfully decremented
        return true;
    }

    public String getLocation() {
        return location;
    }

    public Item getProductInSlot() {
        return productInSlot;
    }

    public int getProductRemaining() {
        return productRemaining;
    }
}
