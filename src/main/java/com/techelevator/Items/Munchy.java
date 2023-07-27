package com.techelevator.Items;

import java.math.BigDecimal;

public class Munchy extends Item
{
    public Munchy(String productName, String productType, BigDecimal price, String slotLocation)
    {
        super(productName, productType, price, slotLocation);
    }

    @Override
    public String getDispenseMessage() {
        return "Crunch Crunch, Yum!";
    }
}
