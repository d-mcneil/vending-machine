package com.techelevator.Menus;

import com.techelevator.Accounting.Account;
import com.techelevator.CustomConstants;

public class FinishingMenu extends Menu
{
    public FinishingMenu(Account account)
    {
        super(account.makeChange(),
                CustomConstants.FINISHING_MENU_MESSAGE,
                CustomConstants.FINISHING_MENU_POST_MESSAGE,
                false
        );
    }
}
