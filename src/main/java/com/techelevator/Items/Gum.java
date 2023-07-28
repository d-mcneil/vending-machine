package com.techelevator.Items;

import com.techelevator.CustomConstants;
import java.math.BigDecimal;

public class Gum extends Item
{
    public Gum(String productName, BigDecimal price)
    {
        super(productName, CustomConstants.GUM, price);
    }

    @Override
    public String getDispenseMessage() {
        return CustomConstants.GUM_DISPENSE_MESSAGE;
    }
}
