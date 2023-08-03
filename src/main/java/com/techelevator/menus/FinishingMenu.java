package com.techelevator.menus;

import com.techelevator.accounting.Account;
import com.techelevator.Constants;

public class FinishingMenu extends Menu
{
    public FinishingMenu(Account account)
    {
        super(account.makeChange(),
                Constants.FINISHING_MENU_MESSAGE,
                Constants.FINISHING_MENU_POST_MESSAGE,
                false
        );
    }
}
