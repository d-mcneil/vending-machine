package com.techelevator.Items;

import java.math.BigDecimal;

public class Gum extends Item
{
    public Gum(String productName, BigDecimal price)
    {
        super(productName, "Gum", price);
    }

    @Override
    public String getDispenseMessage() {
        return "Chew Chew, Yum!";
    }
}
