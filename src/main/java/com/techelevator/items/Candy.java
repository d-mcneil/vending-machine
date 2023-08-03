package com.techelevator.items;

import com.techelevator.Constants;

import java.math.BigDecimal;

public class Candy extends Item {
    public Candy(String productName, BigDecimal price) {
        super(productName, Constants.CANDY, price);
    }

    @Override
    public String getDispenseMessage() {
        return Constants.CANDY_DISPENSE_MESSAGE;
    }
}
