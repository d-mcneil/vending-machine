package com.techelevator.MenuTests;

import com.techelevator.menus.DisplayItemMenu;
import com.techelevator.menus.Menu;
import com.techelevator.inventory.InventoryManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DisplayItemMenuTest {
    InventoryManager inventoryManager;

    @Before
    public void createInventoryManager() {
        inventoryManager = new InventoryManager("src/test/java/com/techelevator/MenuTests/test.csv");

    }

    @Test
    public void menu_constructor_creates_menu_with_correct_values() {
        Menu menu = new DisplayItemMenu(inventoryManager);

        String[] options = menu.getMenuOptions();

        Assert.assertNull(menu.getPostMessage());
        Assert.assertFalse(menu.isCommandLinePrompt());
        Assert.assertEquals("These are your options to choose from:", menu.getMenuMessage());
        Assert.assertEquals("A1  $1.65  Remaining: 5        U-Chews", options[0]);
        Assert.assertEquals("B4  $3.55  Remaining: 5        Mountain Melter", options[1]);
        Assert.assertEquals("C3  $2.95  Remaining: 5        Moonpie", options[2]);
        Assert.assertEquals("D2  $2.35  Remaining: 5        Preengles", options[3]);
    }

    @Test
    public void menu_constructor_creates_menu_with_correct_values_when_product_quantity_reduced() {
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(3));

        Menu menu = new DisplayItemMenu(inventoryManager);

        String[] options = menu.getMenuOptions();

        Assert.assertEquals("A1  $1.65  Remaining: 1        U-Chews", options[0]);
        Assert.assertEquals("B4  $3.55  Remaining: 2        Mountain Melter", options[1]);
        Assert.assertEquals("C3  $2.95  Remaining: 3        Moonpie", options[2]);
        Assert.assertEquals("D2  $2.35  Remaining: 4        Preengles", options[3]);
    }

    @Test
    public void menu_constructor_creates_menu_with_correct_values_when_product_sold_out() {
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(0));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(1));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(2));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(3));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(3));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(3));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(3));
        inventoryManager.dispenseInventory(inventoryManager.getInventory().get(3));
        Menu menu = new DisplayItemMenu(inventoryManager);

        String[] options = menu.getMenuOptions();

        Assert.assertEquals("A1  $1.65  Remaining: SOLD OUT U-Chews", options[0]);
        Assert.assertEquals("B4  $3.55  Remaining: SOLD OUT Mountain Melter", options[1]);
        Assert.assertEquals("C3  $2.95  Remaining: SOLD OUT Moonpie", options[2]);
        Assert.assertEquals("D2  $2.35  Remaining: SOLD OUT Preengles", options[3]);
    }
}



