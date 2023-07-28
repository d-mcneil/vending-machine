package com.techelevator.Items;

import java.math.BigDecimal;

public class Drink extends Item
{

    public Drink(String productName, BigDecimal price)
    {
        super(productName, "Drink", price);
    }

    @Override
    public String getDispenseMessage()
    {
        return "Glug Glug, Yum!";
    }
}
