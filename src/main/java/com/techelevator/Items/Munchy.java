package com.techelevator.Items;

import java.math.BigDecimal;

public class Munchy extends Item
{
    public Munchy(String productName, BigDecimal price)
    {
        super(productName, "Munchy", price);
    }

    @Override
    public String getDispenseMessage() {
        return "Crunch Crunch, Yum!";
    }
}
