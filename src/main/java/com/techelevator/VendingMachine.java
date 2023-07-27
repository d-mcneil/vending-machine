package com.techelevator;

import com.techelevator.Accounting.Account;
import com.techelevator.Menus.DisplayItemMenu;
import com.techelevator.Menus.MainMenu;
import com.techelevator.Menus.Menu;
import com.techelevator.Menus.PurchaseMenu;
import com.techelevator.inventory.InventoryManager;

import java.awt.*;
import java.util.Scanner;

public class VendingMachine {
    // Initialize
    private Scanner userInputScanner = new Scanner(System.in);
    private InventoryManager inventoryManager = new InventoryManager();
    private Menu mainMenu = new MainMenu();
    private Menu displayItemMenu = new DisplayItemMenu(inventoryManager);
    private Account account = new Account();
    //    private Menu purchaseMenu = new PurchaseMenu(account);
    private String userInput = "";
    String userPurchasingInput = "";
    private final String CHOICE_ONE = "1";
    private final String CHOICE_TWO = "2";
    private final String CHOICE_THREE = "3";

    public void run() {
        // Welcome message
        System.out.println("************************************************");
        System.out.println("* Welcome to Dean and Michel's Vending Machine *");
        System.out.println("************************************************");
        System.out.println();



        while (true) { // MAIN MENU LOOP
            do {
                System.out.println("\n\n\nMAIN MENU");
                mainMenu.displayMenu(); // START USER AT MAIN MENU
                userInput = userInputScanner.nextLine();
            } while (!userInput.equals(CHOICE_ONE) && !userInput.equals(CHOICE_TWO) && !userInput.equals(CHOICE_THREE));

            switch (userInput) {
                case CHOICE_ONE:
                    displayItemMenu.displayMenu();
                    break;
                case CHOICE_TWO:
                    purchasingLoop();
                    break;
                case CHOICE_THREE: // exit
                    System.out.println();
                    System.out.println("******************************************************");
                    System.out.println("* Thanks for Using Dean and Michel's Vending Machine *");
                    System.out.println("******************************************************");
                    System.exit(0);
            }
        }





    }

    private void purchasingLoop() {
        while (true) {
            do {
                System.out.println("\n\n\n\nPURCHASING MENU");
                new PurchaseMenu(account).displayMenu(); // START USER AT PURCHASING MENU
                userPurchasingInput = userInputScanner.nextLine();
            } while (!userInput.equals(CHOICE_ONE) && !userInput.equals(CHOICE_TWO) && !userInput.equals(CHOICE_THREE));






            // 1 = feed money
            // 2 = select product
            // 3 = finish transaction

            switch (userPurchasingInput) {
                case CHOICE_ONE:
                    feedMoney();
                    break;
                case CHOICE_TWO:
                    break;

                case CHOICE_THREE:
                    return;
//                    break;
            }
//            break;
            /*
             * while (purchasing)
             * {
             *       new PurchaseMenu(account).displayMenu();
             *       switch (userInput)
             *       {
             *           case CHOICE_ONE:
             *               feedMoney;
             *               break;
             *           case CHOICE_TWO:
             *               displayItemMenu.displayMenu()
             *               sout("enter an item code);
             *               userInput = scanner.nextLine();
             *               if (valid)
             *               {
             *                   dispense();
             *                       if (LocalDate.now().getMonth == august) {
             *                           if (nextItemSalePrice) {
             *
             *                   sout(dispenseMessage);
             *               }
             *               else if (invalid || sold out)
             *               {
             *                   return to purchaseMenu;
             *               }
             *           case CHOICE_THREE:
             *       }
             * }
             * */



        }
    }


    private void feedMoney() {
        int moneyToAdd = 0;
        while (true) {
            System.out.println("Enter the amount of money to add:");
            if (userInputScanner.hasNextInt()) {
                moneyToAdd = userInputScanner.nextInt();
                if (moneyToAdd > 0) {
                    account.feedMoney(moneyToAdd);
                    break;
                }
            } else {
                userInputScanner.next();
            }
        }
    }


}
