package com.techelevator.Items;

import java.math.BigDecimal;

public class Munchy extends Item
{
    public Munchy(String productName, String productType, BigDecimal price)
    {
        super(productName, productType, price);
    }

    @Override
    public String getDispenseMessage() {
        return "Crunch Crunch, Yum!";
    }
}
