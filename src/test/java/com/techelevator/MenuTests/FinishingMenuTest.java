package com.techelevator.MenuTests;

import com.techelevator.accounting.Account;
import com.techelevator.menus.FinishingMenu;
import com.techelevator.menus.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FinishingMenuTest {
    @Test
    public void menu_constructor_creates_menu_with_correct_values(){
        Account account = new Account();
        account.feedMoney(5);
        account.deductFromBalance(BigDecimal.valueOf(0.60));

        Menu menu = new FinishingMenu(account);
        String[] options = menu.getMenuOptions();

        Assert.assertEquals("Your change is:\n", options[0]);
        Assert.assertEquals("Quarters: 17", options[1]);
        Assert.assertEquals("Dimes: 1", options[2]);
        Assert.assertEquals("Nickels: 1", options[3]);
        Assert.assertEquals("Transaction Completed", menu.getMenuMessage());
        Assert.assertEquals("Your new balance is $0.00", menu.getPostMessage());
        Assert.assertFalse(menu.isCommandLinePrompt());
    }
}
