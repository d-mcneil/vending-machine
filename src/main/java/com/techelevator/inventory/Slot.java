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

    public String getLocation() {
        return location;
    }

    public Item getProductInSlot() {
        return productInSlot;
    }

    public int getProductRemaining() {
        return productRemaining;
    }

    public void setProductRemaining(int productRemaining) { // TODO: replace with decrement product remaining
        this.productRemaining = productRemaining;
    }
}
