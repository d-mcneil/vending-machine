package com.techelevator.items_tests;

import com.techelevator.items.Munchy;
import com.techelevator.items.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MunchyTests {
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void createItems() {
        item1 = new Munchy("Preengles", BigDecimal.valueOf(2.35));
        item2 = new Munchy("Stackers", BigDecimal.valueOf(2.65));
        item3 = new Munchy("Chippos", BigDecimal.valueOf(3.85));
    }

    @Test
    public void constructor_creates_item_with_correct_values() {
        Assert.assertEquals("Preengles", item1.getProductName());
        Assert.assertEquals("Stackers", item2.getProductName());
        Assert.assertEquals("Chippos", item3.getProductName());

        Assert.assertEquals(BigDecimal.valueOf(2.35), item1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.65), item2.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(3.85), item3.getPrice());

        Assert.assertEquals("Munchy", item1.getProductType());
        Assert.assertEquals("Munchy", item2.getProductType());
        Assert.assertEquals("Munchy", item3.getProductType());
    }

    @Test
    public void getDispenseMessage_returns_correct_message() {
        Assert.assertEquals("Crunch Crunch, Yum!", item1.getDispenseMessage());
        Assert.assertEquals("Crunch Crunch, Yum!", item2.getDispenseMessage());
        Assert.assertEquals("Crunch Crunch, Yum!", item3.getDispenseMessage());
    }
}
