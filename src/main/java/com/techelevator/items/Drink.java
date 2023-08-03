package com.techelevator.items;

import com.techelevator.Constants;

import java.math.BigDecimal;

public class Drink extends Item {
    public Drink(String productName, BigDecimal price) {
        super(productName, Constants.DRINK, price);
    }

    @Override
    public String getDispenseMessage() {
        return Constants.DRINK_DISPENSE_MESSAGE;
    }
}
