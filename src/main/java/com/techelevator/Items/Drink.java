package com.techelevator.Items;

import java.math.BigDecimal;

public class Drink extends Item
{

    public Drink(String productName, String productType, BigDecimal price, String slotLocation)
    {
        super(productName, productType, price, slotLocation);
    }

    @Override
    public String getDispenseMessage()
    {
        return "Glug Glug, Yum!";
    }
}
