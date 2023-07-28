package com.techelevator.ItemTests;

import com.techelevator.Items.Munchy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MunchyTest {
    @Test
    public void drink_Prints_Correct_Dispensing_Message() {
        Munchy myMunchy = new Munchy("Popcorn", new BigDecimal("1.75"));

        Assert.assertEquals("Crunch Crunch, Yum!", myMunchy.getDispenseMessage());
    }

    @Test
    public void drink_constructor() {
        Munchy myMunchyTest1 = new Munchy("Preengles", new BigDecimal("2.35"));
        Munchy myMunchyTest2 = new Munchy("Stackers", new BigDecimal("2.65"));
        Munchy myMunchyTest3 = new Munchy("Chippos", new BigDecimal("3.85"));

        Assert.assertEquals("Preengles", myMunchyTest1.getProductName());
        Assert.assertEquals("Stackers", myMunchyTest2.getProductName());
        Assert.assertEquals("Chippos", myMunchyTest3.getProductName());
    }
}