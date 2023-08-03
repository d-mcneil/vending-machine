package com.techelevator.menus_tests;

import com.techelevator.accounting.Account;
import com.techelevator.menus.Menu;
import com.techelevator.menus.PurchaseMenu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PurchaseMenuTests {
    Account account;

    @Before
    public void createAccount() {
        account = new Account();
    }

    @Test
    public void constructor_creates_menu_with_correct_values() {
        account.feedMoney(10);
        account.deductFromBalance(BigDecimal.valueOf(1.9));

        Menu menu = new PurchaseMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Current Money Provided: $8.10\n", options[0]);
        Assert.assertEquals("(1) Feed Money", options[1]);
        Assert.assertEquals("(2) Select Product", options[2]);
        Assert.assertEquals("(3) Finish Transaction", options[3]);
        Assert.assertEquals(4, options.length);
        Assert.assertEquals("Purchasing Menu", menu.getMenuMessage());
        Assert.assertEquals("Select An Option (1/2/3)", menu.getPostMessage());
        Assert.assertTrue(menu.isPostMessageACommandLinePrompt());
    }

    @Test
    public void constructor_creates_menu_with_correct_values_for_zero_balance() {
        Menu menu = new PurchaseMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Current Money Provided: $0.00\n", options[0]);
        Assert.assertEquals("(1) Feed Money", options[1]);
        Assert.assertEquals("(2) Select Product", options[2]);
        Assert.assertEquals("(3) Finish Transaction", options[3]);
        Assert.assertEquals(4, options.length);
        Assert.assertEquals("Purchasing Menu", menu.getMenuMessage());
        Assert.assertEquals("Select An Option (1/2/3)", menu.getPostMessage());
        Assert.assertTrue(menu.isPostMessageACommandLinePrompt());
    }
}
