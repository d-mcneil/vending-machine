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
    public void constructor_creates_slot_with_correct_values(){
        Slot slot1 = new Slot("A1", new Candy("Snykkers", BigDecimal.valueOf(4.25)));
        Slot slot2 = new Slot("D3", new Drink("Mountain Melter", BigDecimal.valueOf(3.55)));

        Item item1 = slot1.getProductInSlot();
        Item item2 = slot2.getProductInSlot();

        Assert.assertEquals("A1", slot1.getLocation());
        Assert.assertEquals("D3", slot2.getLocation());
        Assert.assertEquals(5, slot1.getProductRemaining());
        Assert.assertEquals(5, slot2.getProductRemaining());
        Assert.assertEquals("Candy", item1.getProductType());
        Assert.assertEquals("Drink", item2.getProductType());
        Assert.assertEquals("Snykkers", item1.getProductName());
        Assert.assertEquals("Mountain Melter", item2.getProductName());
        Assert.assertEquals("Yummy Yummy, So Sweet!", item1.getDispenseMessage());
        Assert.assertEquals("Glug Glug, Yum!", item2.getDispenseMessage());
        Assert.assertEquals(BigDecimal.valueOf(4.25), item1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(3.55), item2.getPrice());
    }
}
