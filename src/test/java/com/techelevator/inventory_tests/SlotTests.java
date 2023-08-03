package com.techelevator.inventory_tests;

import com.techelevator.items.Candy;
import com.techelevator.items.Drink;
import com.techelevator.items.Item;
import com.techelevator.inventory.Slot;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SlotTests {
    @Test
    public void constructor_creates_object_with_correct_values(){
        Item item1 = new Candy("Snykkers", new BigDecimal("4.25"));
        Item item2 = new Drink("Mountain Melter", new BigDecimal("3.55"));
        Slot slot1 = new Slot("A1", item1);
        Slot slot2 = new Slot("D3", item2);

        Assert.assertEquals("A1", slot1.getLocation());
        Assert.assertEquals("D3", slot2.getLocation());
        Assert.assertEquals("Candy", slot1.getProductInSlot().getProductType());
        Assert.assertEquals("Drink", slot2.getProductInSlot().getProductType());
        Assert.assertEquals("Snykkers", slot1.getProductInSlot().getProductName());
        Assert.assertEquals("Mountain Melter", slot2.getProductInSlot().getProductName());
        Assert.assertEquals("Yummy Yummy, So Sweet!", slot1.getProductInSlot().getDispenseMessage());
        Assert.assertEquals("Glug Glug, Yum!", slot2.getProductInSlot().getDispenseMessage());
        Assert.assertEquals(BigDecimal.valueOf(4.25), slot1.getProductInSlot().getPrice());
        Assert.assertEquals(BigDecimal.valueOf(3.55), slot2.getProductInSlot().getPrice());
        Assert.assertEquals(5, slot1.getProductRemaining());
        Assert.assertEquals(5, slot2.getProductRemaining());
    }
}
