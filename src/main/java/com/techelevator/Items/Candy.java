package com.techelevator.Items;

import java.math.BigDecimal;

public class Candy extends Item
{
    public Candy(String productName, String productType, BigDecimal price, String slotLocation)
    {
        super(productName, productType, price, slotLocation);
    }

    @Override
    public String getDispenseMessage() {
        return "Yummy Yummy, So Sweet!";
    }
}
