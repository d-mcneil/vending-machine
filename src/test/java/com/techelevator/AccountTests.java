package com.techelevator;

import com.techelevator.Accounting.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountTests {
    Account account;

    @Before
    public void createAccount() {
        account = new Account();
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_dimes_and_nickels_for_90_cents(){
        account.feedMoney(5);
        account.deductFromBalance(BigDecimal.valueOf(4.10));

        String[] change = account.makeChange();

        Assert.assertEquals("Quarters: 3", change[1]);
        Assert.assertEquals("Dimes: 1", change[2]);
        Assert.assertEquals("Nickels: 1", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_and_dimes_for_3_dollars_and_70_cents(){
        account.feedMoney(5);
        account.deductFromBalance(BigDecimal.valueOf(1.30));

        String[] change = account.makeChange();

        Assert.assertEquals("Quarters: 14", change[1]);
        Assert.assertEquals("Dimes: 2", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_for_20_dollars(){
        account.feedMoney(20);

        String[] change = account.makeChange();

        Assert.assertEquals("Quarters: 80", change[1]);
        Assert.assertEquals("Dimes: 0", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }

    @Test
    public void makeChange_provides_correct_change_in_quarters_for_empty_account(){
        String[] change = account.makeChange();

        Assert.assertEquals("Quarters: 0", change[1]);
        Assert.assertEquals("Dimes: 0", change[2]);
        Assert.assertEquals("Nickels: 0", change[3]);
    }
}
