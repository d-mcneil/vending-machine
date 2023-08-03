package com.techelevator.items;

import com.techelevator.Constants;
import java.math.BigDecimal;

public class Gum extends Item
{
    public Gum(String productName, BigDecimal price)
    {
        super(productName, Constants.GUM, price);
    }

    @Override
    public String getDispenseMessage() {
        return Constants.GUM_DISPENSE_MESSAGE;
    }
}
