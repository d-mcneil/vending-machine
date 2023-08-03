package com.techelevator.ItemTests;


import com.techelevator.items.Gum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest
{
    @Test
    public void gum_Prints_Correct_Dispensing_Message()
    {
        Gum myGum = new Gum("Chiclets", new BigDecimal("1.35"));

        Assert.assertEquals("Chew Chew, Yum!", myGum.getDispenseMessage());
    }


    @Test
    public void gum_constructor()
    {
        Gum myGumTest1 = new Gum("Moonpie", new BigDecimal("2.95"));
        Gum myGumTest2 = new Gum("Wonka Bar", new BigDecimal("2.35"));
        Gum myGumTest3 = new Gum("Caramel Bar", new BigDecimal("2.25"));

        Assert.assertEquals("Moonpie", myGumTest1.getProductName());
        Assert.assertEquals("Wonka Bar", myGumTest2.getProductName());
        Assert.assertEquals("Caramel Bar", myGumTest3.getProductName());

        Assert.assertEquals(BigDecimal.valueOf(2.95), myGumTest1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.35), myGumTest2.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.25), myGumTest3.getPrice());

        Assert.assertEquals("Gum", myGumTest1.getProductType());
        Assert.assertEquals("Gum", myGumTest2.getProductType());
        Assert.assertEquals("Gum", myGumTest3.getProductType());
    }
}
