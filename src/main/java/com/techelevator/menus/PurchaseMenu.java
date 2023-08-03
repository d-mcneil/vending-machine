package com.techelevator.menus;

import com.techelevator.accounting.Account;

import java.math.RoundingMode;

public class PurchaseMenu extends Menu {
    public PurchaseMenu(Account account) {
        super(
                new String[]{"Current Money Provided: $" + account.getBalance().setScale(2, RoundingMode.HALF_UP) + "\n" ,"(1) Feed Money", "(2) Select Product", "(3) Finish Transaction"}
                , "Purchasing Menu"
                ,"Select An Option (1/2/3)", true
        );
    }
}
