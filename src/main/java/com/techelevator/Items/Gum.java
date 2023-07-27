package com.techelevator.Items;

import java.math.BigDecimal;

public class Gum extends Item
{
    public Gum(String productName, String productType, BigDecimal price)
    {
        super(productName, productType, price);
    }

    @Override
    public String getDispenseMessage() {
        return "Chew Chew, Yum!";
    }
}
