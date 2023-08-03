package com.techelevator.items_tests;

import com.techelevator.items.Candy;
import com.techelevator.items.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTests {
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void createItems() {
        item1 = new Candy("Moonpie", BigDecimal.valueOf(2.95));
        item2 = new Candy("Wonka Bar", BigDecimal.valueOf(2.35));
        item3 = new Candy("Caramel Bar", BigDecimal.valueOf(2.25));
    }

    @Test
    public void constructor_creates_item_with_correct_values() {
        Assert.assertEquals("Moonpie", item1.getProductName());
        Assert.assertEquals("Wonka Bar", item2.getProductName());
        Assert.assertEquals("Caramel Bar", item3.getProductName());

        Assert.assertEquals(BigDecimal.valueOf(2.95), item1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.35), item2.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.25), item3.getPrice());

        Assert.assertEquals("Candy", item1.getProductType());
        Assert.assertEquals("Candy", item2.getProductType());
        Assert.assertEquals("Candy", item3.getProductType());
    }

    @Test
    public void getDispenseMessage_returns_correct_message() {
        Assert.assertEquals("Yummy Yummy, So Sweet!", item1.getDispenseMessage());
        Assert.assertEquals("Yummy Yummy, So Sweet!", item2.getDispenseMessage());
        Assert.assertEquals("Yummy Yummy, So Sweet!", item3.getDispenseMessage());
    }
}
