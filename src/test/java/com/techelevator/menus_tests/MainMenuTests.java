package com.techelevator.menus_tests;

import com.techelevator.menus.MainMenu;
import com.techelevator.menus.Menu;
import org.junit.Assert;
import org.junit.Test;

public class MainMenuTests {
    @Test
    public void constructor_creates_menu_with_correct_values() {
        Menu menu = new MainMenu();
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Main Menu", menu.getMenuMessage());
        Assert.assertEquals("(1) Display Vending Machine Items", options[0]);
        Assert.assertEquals("(2) Purchase", options[1]);
        Assert.assertEquals("(3) Exit", options[2]);
        Assert.assertEquals(3, options.length);
        Assert.assertEquals("Select An Option (1/2/3)", menu.getPostMessage());
        Assert.assertTrue(menu.isPostMessageACommandLinePrompt());
    }
}
