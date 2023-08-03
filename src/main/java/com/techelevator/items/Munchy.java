package com.techelevator.items;

import com.techelevator.Constants;
import java.math.BigDecimal;

public class Munchy extends Item
{
    public Munchy(String productName, BigDecimal price)
    {
        super(productName, Constants.MUNCHY, price);
    }

    @Override
    public String getDispenseMessage() {
        return Constants.MUNCHY_DISPENSE_MESSAGE;
    }
}
