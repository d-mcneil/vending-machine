package com.techelevator.items_tests;

import com.techelevator.items.Gum;
import com.techelevator.items.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTests {
    Item item1;
    Item item2;
    Item item3;

    @Before
    public void createItems() {
        item1 = new Gum("Chiclets", BigDecimal.valueOf(1.35));
        item2 = new Gum("Teaberry", BigDecimal.valueOf(1.65));
        item3 = new Gum("Singlemint", BigDecimal.valueOf(2.35));
    }

    @Test
    public void constructor_creates_item_with_correct_values() {
        Assert.assertEquals("Chiclets", item1.getProductName());
        Assert.assertEquals("Teaberry", item2.getProductName());
        Assert.assertEquals("Singlemint", item3.getProductName());

        Assert.assertEquals(BigDecimal.valueOf(1.35), item1.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(1.65), item2.getPrice());
        Assert.assertEquals(BigDecimal.valueOf(2.35), item3.getPrice());

        Assert.assertEquals("Gum", item1.getProductType());
        Assert.assertEquals("Gum", item2.getProductType());
        Assert.assertEquals("Gum", item3.getProductType());
    }

    @Test
    public void getDispenseMessage_returns_correct_message() {
        Assert.assertEquals("Chew Chew, Yum!", item1.getDispenseMessage());
        Assert.assertEquals("Chew Chew, Yum!", item2.getDispenseMessage());
        Assert.assertEquals("Chew Chew, Yum!", item3.getDispenseMessage());
    }
}
