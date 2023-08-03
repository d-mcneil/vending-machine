package com.techelevator.menus;

import com.techelevator.Constants;
import com.techelevator.accounting.Account;

import java.math.RoundingMode;

public class PurchaseMenu extends Menu {
    public PurchaseMenu(Account account) {
        super(
                Constants.PURCHASE_MENU_MESSAGE,
                new String[]{
                        // Option zero shows the user's current balance.
                        Constants.PURCHASE_MENU_OPTION_ZERO
                                + account.getBalance().setScale(2, RoundingMode.HALF_UP)
                                + "\n",
                        Constants.PURCHASE_MENU_OPTION_1, // Feed Money
                        Constants.PURCHASE_MENU_OPTION_2, // Select Product
                        Constants.PURCHASE_MENU_OPTION_3 // Finish Transaction
                },
                Constants.PURCHASE_MENU_POST_MESSAGE,
                true
        );
    }
}
