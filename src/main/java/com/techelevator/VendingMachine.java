package com.techelevator;

import com.techelevator.Accounting.Account;
import com.techelevator.Menus.*;
import com.techelevator.Menus.Menu;
import com.techelevator.Reports.Logger;
import com.techelevator.inventory.InventoryManager;
import com.techelevator.inventory.Slot;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {
    // Initialize
    private Scanner userInputScanner = new Scanner(System.in);
    private InventoryManager inventoryManager = new InventoryManager();
    private Menu mainMenu = new MainMenu();
//    private Menu displayItemMenu = new DisplayItemMenu(inventoryManager);
    private Account account = new Account();
    //    private Menu purchaseMenu = new PurchaseMenu(account);
    private String userInput = "";
    String userPurchasingInput = "";
    String userDispensingInput = "";
    private final String CHOICE_ONE = "1";
    private final String CHOICE_TWO = "2";
    private final String CHOICE_THREE = "3";
    private Logger log = new Logger();

    public void run() {
        // Welcome message
        System.out.println("************************************************");
        System.out.println("* Welcome to Dean and Michel's Vending Machine *");
        System.out.println("************************************************");
        System.out.println();



        while (true) { // MAIN MENU LOOP
            do {
                System.out.println("\n\n\nMAIN MENU");
                System.out.print(mainMenu.getMenuDisplayString()); // START USER AT MAIN MENU
                userInput = userInputScanner.nextLine();
            } while (!userInput.equals(CHOICE_ONE) && !userInput.equals(CHOICE_TWO) && !userInput.equals(CHOICE_THREE));

            switch (userInput) {
                case CHOICE_ONE:
                    System.out.print(new DisplayItemMenu(inventoryManager).getMenuDisplayString());
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
            userPurchasingInput = "";
            do {
                System.out.println("\n\n");
                System.out.print(new PurchaseMenu(account).getMenuDisplayString()); // START USER AT PURCHASING MENU
                userPurchasingInput = userInputScanner.nextLine();
            } while (!userPurchasingInput.equals(CHOICE_ONE) && !userPurchasingInput.equals(CHOICE_TWO) && !userPurchasingInput.equals(CHOICE_THREE));

            // 1 = feed money
            // 2 = select product
            // 3 = finish transaction

            switch (userPurchasingInput) {
                case CHOICE_ONE:
                    feedMoney();
                    break;
                case CHOICE_TWO:
                    dispensingLoop();
                    break;
                case CHOICE_THREE:
                    log.logPurchase("GIVE CHANGE", account.getBalance(), BigDecimal.ZERO);
                    System.out.print(new FinishingMenu(account).getMenuDisplayString());
                    account.setBalanceToZero();
                    return;
            }


        }
    }

    private void dispensingLoop() {
        userDispensingInput = "";

        System.out.println(new DisplayItemMenu(inventoryManager).getMenuDisplayString());
        do {
            System.out.print("\nEnter the code for the item you wish to purchase: ");
            userDispensingInput = userInputScanner.nextLine().toLowerCase();
        } while (!userDispensingInput.matches("[a-zA-z]{1}[1-9]{1}"));

        for (Slot slot : inventoryManager.getInventory()) {
            if (userDispensingInput.equals(slot.getLocation().toLowerCase())) {
                if (slot.getProductRemaining() > 0) {
                    if (account.getBalance().compareTo(slot.getProductInSlot().getPrice()) >= 0) {
                        System.out.println(slot.getProductInSlot().getDispenseMessage());
                        // amountToDeduct is actually deducting from the account AND storing amount deducted in variable
                        BigDecimal amountToDeduct = account.deductFromBalance(slot.getProductInSlot().getPrice());
                        inventoryManager.dispenseInventory(slot);
                        log.logPurchase(slot.getProductInSlot().getProductName() + " " + slot.getLocation(), amountToDeduct, account.getBalance());
                    } else {
                        System.out.println("Sorry, you haven't fed in enough money to purchase that item. Please add more money.");
                    }
                } else {
                    System.out.println("Sorry, that product is sold out.");
                }
                return;
            }
        }

        System.out.println("Sorry, that isn't a valid product code.");
    }


    private void feedMoney() {
        int moneyToAdd = 0;
        while (true) {
            System.out.print("Enter the amount of money to add:");
            if (userInputScanner.hasNextInt()) {
                moneyToAdd = Integer.parseInt(userInputScanner.nextLine());
                if (moneyToAdd > 0) {
                    account.feedMoney(moneyToAdd);
                    log.logPurchase("FEED MONEY", BigDecimal.valueOf(moneyToAdd), account.getBalance());
                    break;
                }
            } else {
                userInputScanner.nextLine();
            }
        }
    }


}
