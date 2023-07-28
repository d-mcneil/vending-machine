package com.techelevator.Menus;

import com.techelevator.Accounting.Account;

public class PurchaseMenu extends Menu {
    public PurchaseMenu(Account account) {
        super(
                new String[]{"(1) Feed Money", "(2) Select Product", "(3) Finish Transaction"}
                , "Purchasing Menu\nCurrent Money Provided: $" + account.getBalance()
                ,"Select An Option (1/2/3)", true
        );
    }
}
