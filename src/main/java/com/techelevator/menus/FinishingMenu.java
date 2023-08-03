package com.techelevator.menus;

import com.techelevator.accounting.Account;
import com.techelevator.Constants;

public class FinishingMenu extends Menu {
    public FinishingMenu(Account account) {
        super(
                Constants.FINISHING_MENU_MESSAGE,
                account.makeChange(),
                /*  For account.makeChange() (the options argument)
                 *   ** Option 0 shows "Your change is: \n".
                 *   ** Option 1 shows quarters dispensed.
                 *   ** Option 2 shows dimes dispensed.
                 *   ** Option 3 shows nickels dispensed. */
                Constants.FINISHING_MENU_POST_MESSAGE,
                false
        );
    }
}
