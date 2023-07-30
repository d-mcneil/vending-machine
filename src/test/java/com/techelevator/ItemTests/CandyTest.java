package com.techelevator.ItemTests;

import com.techelevator.Items.Candy;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest
{
    @Test
    public void candy_Prints_Correct_Dispensing_Message()
    {
        Candy myCandy = new Candy("Snykkers", new BigDecimal("4.25"));

        Assert.assertEquals("Yummy Yummy, So Sweet!", myCandy.getDispenseMessage());
    }


    @Test
    public void candy_constructor()
    {
        Candy myCandyTest1 = new Candy("Moonpie", new BigDecimal("2.95"));
        Candy myCandyTest2 = new Candy("Wonka Bar", new BigDecimal("2.35"));
        Candy myCandyTest3 = new Candy("Caramel Bar", new BigDecimal("2.25"));

        Assert.assertEquals("Moonpie", myCandyTest1.getProductName());
        Assert.assertEquals("Wonka Bar", myCandyTest2.getProductName());
        Assert.assertEquals("Caramel Bar", myCandyTest3.getProductName());

        Assert.assertEquals(BigDecimal.valueOf(2.95), myCandyTest1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.35), myCandyTest2.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.25), myCandyTest3.getPrice());

        Assert.assertEquals("Candy", myCandyTest1.getProductType());
        Assert.assertEquals("Candy", myCandyTest2.getProductType());
        Assert.assertEquals("Candy", myCandyTest3.getProductType());
    }


}
