package com.techelevator.inventory_tests;

import com.techelevator.inventory.InventoryManager;
import com.techelevator.inventory.Slot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class InventoryManagerTests {
    InventoryManager inventoryManager;

    @Before
    public void createInventoryManager() {
        inventoryManager = new InventoryManager("src/test/java/com/techelevator/test_inventory.csv");
    }

    @Test
    public void dispenseInventory_correctly_dispenses_product() {
        Slot slot = inventoryManager.getInventory().get(0);

        boolean wasProductDispensedSuccessfully = inventoryManager.dispenseInventory(slot);
        int productRemaining = slot.getProductRemaining();

        Assert.assertTrue(wasProductDispensedSuccessfully);
        Assert.assertEquals(4, productRemaining);
    }

    @Test
    public void dispenseInventory_does_not_dispense_product_when_sold_out() {
        Slot slot = inventoryManager.getInventory().get(0);

        inventoryManager.dispenseInventory(slot);
        inventoryManager.dispenseInventory(slot);
        inventoryManager.dispenseInventory(slot);
        inventoryManager.dispenseInventory(slot);
        inventoryManager.dispenseInventory(slot);
        boolean wasProductDispensedSuccessfully = inventoryManager.dispenseInventory(slot);
        int productRemaining = slot.getProductRemaining();

        Assert.assertFalse(wasProductDispensedSuccessfully);
        Assert.assertEquals(0, productRemaining);
    }

    @Test
    public void getInventoryOptionsAsDisplayStringArray_correctly_converts_inventory_file() {
        String[] options = inventoryManager.getInventoryOptionsAsDisplayStringArray();

        Assert.assertEquals("A1  $1.65  Remaining: 5        U-Chews", options[0]);
        Assert.assertEquals("B4  $3.55  Remaining: 5        Mountain Melter", options[1]);
        Assert.assertEquals("C3  $2.95  Remaining: 5        Moonpie", options[2]);
        Assert.assertEquals("D2  $2.35  Remaining: 5        Preengles", options[3]);
    }

    @Test
    public void constructor_creates_list_of_slots_from_inventory_file(){
        List<Slot> inventory = inventoryManager.getInventory();
        Slot slot1 = inventory.get(0);
        Slot slot2 = inventory.get(1);
        Slot slot3 = inventory.get(2);
        Slot slot4 = inventory.get(3);

        Assert.assertEquals("A1", slot1.getLocation());
        Assert.assertEquals(BigDecimal.valueOf(3.55), slot2.getProductInSlot().getPrice());
        Assert.assertEquals(5, slot3.getProductRemaining());
        Assert.assertEquals("Preengles", slot4.getProductInSlot().getProductName());
        Assert.assertEquals("Munchy", slot4.getProductInSlot().getProductType());
        Assert.assertEquals("Chew Chew, Yum!", slot1.getProductInSlot().getDispenseMessage());
    }
}
