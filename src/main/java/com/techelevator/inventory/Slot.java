package com.techelevator.inventory;

import com.techelevator.items.Item;

public class Slot {
    private String location;
    private Item productInSlot;
    private int productRemaining = 5;

    public Slot(String location, Item productInSlot) {
        this.location = location;
        this.productInSlot = productInSlot;
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

    public void setProductRemaining(int productRemaining)
    {
        this.productRemaining = productRemaining;
    }
}
