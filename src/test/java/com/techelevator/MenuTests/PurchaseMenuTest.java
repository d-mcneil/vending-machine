package com.techelevator.MenuTests;

import com.techelevator.Accounting.Account;
import com.techelevator.Menus.FinishingMenu;
import com.techelevator.Menus.Menu;
import com.techelevator.Menus.PurchaseMenu;
import org.junit.Assert;
import org.junit.Test;

public class PurchaseMenuTest
{


    @Test
    public void purchase_menu_constructor_creates_menu_with_correct_values()
    {

        Account account = new Account();
        account.feedMoney(10);
        Menu menu = new PurchaseMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Current Money Provided: $10.00\n", options[0]);
        Assert.assertEquals("(1) Feed Money", options[1]);
        Assert.assertEquals("(2) Select Product", options[2]);
        Assert.assertEquals("(3) Finish Transaction", options[3]);
        Assert.assertEquals("Purchasing Menu", menu.getMenuMessage());
        Assert.assertEquals("Select An Option (1/2/3)", menu.getPostMessage());
        Assert.assertTrue(menu.isCommandLinePrompt());

    }

    @Test
    public void purchase_menu_constructor_creates_menu_with_correct_values_zero_balance()
    {

        Account account = new Account();
        account.setBalanceToZero();
        Menu menu = new PurchaseMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Current Money Provided: $0.00\n", options[0]);
        Assert.assertEquals("(1) Feed Money", options[1]);
        Assert.assertEquals("(2) Select Product", options[2]);
        Assert.assertEquals("(3) Finish Transaction", options[3]);
        Assert.assertEquals("Purchasing Menu", menu.getMenuMessage());
        Assert.assertEquals("Select An Option (1/2/3)", menu.getPostMessage());
        Assert.assertTrue(menu.isCommandLinePrompt());

    }
}
