package com.techelevator.Menus;

import com.techelevator.Accounting.Account;

public class PurchaseMenu extends Menu {
    public PurchaseMenu(Account account) {
        super(new String[]{"(1) Feed Money", "(2) Select Product", "(3) Finish Transaction"}, "Current Money Provided: $" + account.getBalance());
    }

//    @Override
//    public void displayMenu() {
//        System.out.println(this.getMenuMessage());
//        System.out.println();
//        for(String option : this.getMenuOptions())
//        {
//            System.out.println(option);
//        }
//        System.out.println();
//    }


}
