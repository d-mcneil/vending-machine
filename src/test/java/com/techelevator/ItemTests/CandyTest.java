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
        Candy myCandy = new Candy("Snykkers", "Candy", new BigDecimal(4.25));

        Assert.assertEquals("Yummy Yummy, So Sweet!", myCandy.getDispenseMessage());
    }


}
