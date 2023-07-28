package com.techelevator.Items;

import com.techelevator.CustomConstants;
import java.math.BigDecimal;

public class Candy extends Item
{
    public Candy(String productName, BigDecimal price)
    {
        super(productName, CustomConstants.CANDY, price);
    }

    @Override
    public String getDispenseMessage() {
        return CustomConstants.CANDY_DISPENSE_MESSAGE;
    }
}
