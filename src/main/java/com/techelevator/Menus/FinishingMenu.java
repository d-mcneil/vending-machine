package com.techelevator.Menus;

import com.techelevator.Accounting.Account;

public class FinishingMenu extends Menu
{
    public FinishingMenu(Account account)
    {
        super(account.makeChange(),
                "Transaction Completed", "Your new balance is $0.00", false);
    }
}
