package com.techelevator.Items;

import com.techelevator.CustomConstants;
import java.math.BigDecimal;

public class Munchy extends Item
{
    public Munchy(String productName, BigDecimal price)
    {
        super(productName, CustomConstants.MUNCHY, price);
    }

    @Override
    public String getDispenseMessage() {
        return CustomConstants.MUNCHY_DISPENSE_MESSAGE;
    }
}
