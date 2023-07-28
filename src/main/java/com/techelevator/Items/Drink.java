package com.techelevator.Items;

import com.techelevator.CustomConstants;
import java.math.BigDecimal;

public class Drink extends Item
{
    public Drink(String productName, BigDecimal price)
    {
        super(productName, CustomConstants.DRINK, price);
    }

    @Override
    public String getDispenseMessage()
    {
        return CustomConstants.DRINK_DISPENSE_MESSAGE;
    }
}
