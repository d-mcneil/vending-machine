package com.techelevator.Items;

import java.math.BigDecimal;

public class Candy extends Item
{
    public Candy(String productName, String productType, BigDecimal price)
    {
        super(productName, productType, price);
    }

    @Override
    public String getDispenseMessage() {
        return "Yummy Yummy, So Sweet!";
    }
}
