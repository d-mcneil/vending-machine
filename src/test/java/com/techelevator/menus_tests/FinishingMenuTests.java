package com.techelevator.menus_tests;

import com.techelevator.accounting.Account;
import com.techelevator.menus.FinishingMenu;
import com.techelevator.menus.Menu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class FinishingMenuTests {
    Account account;

    @Before
    public void createAccount() {
        account = new Account();
    }

    @Test
    public void constructor_creates_menu_with_correct_values() {
        account.feedMoney(5);
        account.deductFromBalance(BigDecimal.valueOf(0.6));

        Menu menu = new FinishingMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Transaction Completed", menu.getMenuMessage());
        Assert.assertEquals("Your change is:\n", options[0]);
        Assert.assertEquals("Quarters: 17", options[1]);
        Assert.assertEquals("Dimes: 1", options[2]);
        Assert.assertEquals("Nickels: 1", options[3]);
        Assert.assertEquals(4, options.length);
        Assert.assertEquals("Your new balance is $0.00", menu.getPostMessage());
        Assert.assertFalse(menu.isPostMessageACommandLinePrompt());
    }

    @Test
    public void constructor_creates_menu_with_correct_values_for_zero_balance() {
        Menu menu = new FinishingMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Transaction Completed", menu.getMenuMessage());
        Assert.assertEquals("Your change is:\n", options[0]);
        Assert.assertEquals("Quarters: 0", options[1]);
        Assert.assertEquals("Dimes: 0", options[2]);
        Assert.assertEquals("Nickels: 0", options[3]);
        Assert.assertEquals(4, options.length);
        Assert.assertEquals("Your new balance is $0.00", menu.getPostMessage());
        Assert.assertFalse(menu.isPostMessageACommandLinePrompt());
    }
}
