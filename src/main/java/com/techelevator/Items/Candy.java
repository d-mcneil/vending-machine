package com.techelevator.Items;

import java.math.BigDecimal;

public class Candy extends Item
{
    public Candy(String productName, BigDecimal price)
    {
        super(productName, "Candy", price);
    }

    @Override
    public String getDispenseMessage() {
        return "Yummy Yummy, So Sweet!";
    }
}
