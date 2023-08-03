package com.techelevator.items_tests;

import com.techelevator.items.Drink;
import com.techelevator.items.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkTests {
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void createItems() {
        item1 = new Drink("Mountain Melter", BigDecimal.valueOf(3.55));
        item2 = new Drink("7Down", BigDecimal.valueOf(3.25));
        item3 = new Drink("Papsi", BigDecimal.valueOf(3.45));
    }

    @Test
    public void constructor_creates_item_with_correct_values() {
        Assert.assertEquals("Mountain Melter", item1.getProductName());
        Assert.assertEquals("7Down", item2.getProductName());
        Assert.assertEquals("Papsi", item3.getProductName());

        Assert.assertEquals(BigDecimal.valueOf(3.55), item1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(3.25), item2.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(3.45), item3.getPrice());

        Assert.assertEquals("Drink", item1.getProductType());
        Assert.assertEquals("Drink", item2.getProductType());
        Assert.assertEquals("Drink", item3.getProductType());
    }

    @Test
    public void getDispenseMessage_returns_correct_message() {
        Assert.assertEquals("Glug Glug, Yum!", item1.getDispenseMessage());
        Assert.assertEquals("Glug Glug, Yum!", item2.getDispenseMessage());
        Assert.assertEquals("Glug Glug, Yum!", item3.getDispenseMessage());
    }
}
