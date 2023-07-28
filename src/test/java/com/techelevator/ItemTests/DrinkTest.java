package com.techelevator.ItemTests;


import com.techelevator.Items.Drink;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkTest
{
    @Test
    public void drink_Prints_Correct_Dispensing_Message()
    {
        Drink myDrink = new Drink("Mountain Melter", new BigDecimal("3.55"));

        Assert.assertEquals("Glug Glug, Yum!", myDrink.getDispenseMessage());
    }

    @Test
    public void drink_constructor()
    {
        Drink myDrinkTest1 = new Drink("Mountain Melter", new BigDecimal("3.55"));
        Drink myDrinkTest2 = new Drink("7Down", new BigDecimal("3.25"));
        Drink myDrinkTest3 = new Drink("Papsi", new BigDecimal("3.45"));

        Assert.assertEquals("Mountain Melter", myDrinkTest1.getProductName());
        Assert.assertEquals("7Down", myDrinkTest2.getProductName());
        Assert.assertEquals("Papsi", myDrinkTest3.getProductName());

    }

}
