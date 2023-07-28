package com.techelevator;

import com.techelevator.Accounting.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountTests {
    @Test
    public void makeChange_provides_correct_change_in_quarters_dimes_and_nickels(){
        Account account = new Account();

        String[] change = account.makeChange();

        Assert.assertEquals("Quarters: 3", change[0]);
        Assert.assertEquals("Dimes: 1", change[1]);
        Assert.assertEquals("Nickels: 1", change[2]);
    }
}
