package com.techelevator;

import com.techelevator.Accounting.Account;
import com.techelevator.Menus.*;
import com.techelevator.Menus.Menu;
import com.techelevator.Reports.Logger;
import com.techelevator.console_managers.PrintManager;
import com.techelevator.inventory.InventoryManager;
import com.techelevator.inventory.Slot;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {
    // Initialize
    private final Scanner userInputScanner = new Scanner(System.in);
    private final PrintManager printManager = new PrintManager();
    private final InventoryManager inventoryManager = new InventoryManager();
    private Menu mainMenu = new MainMenu();
    private final Account account = new Account();
    private final String CHOICE_ONE = "1";
    private final String CHOICE_TWO = "2";
    private final String CHOICE_THREE = "3";
    private final Logger log = new Logger();

    public void run() {
        printManager.printWelcomeBanner();

        while (true) { // MAIN MENU LOOP
            String userInput = "";
            do {
                printManager.printMenu(mainMenu, -1);
                userInput = userInputScanner.nextLine();
            } while (!userInput.equals(CHOICE_ONE) && !userInput.equals(CHOICE_TWO) && !userInput.equals(CHOICE_THREE));

            switch (userInput) {
                case CHOICE_ONE:
                    printManager.printMenu(new DisplayItemMenu(inventoryManager), 7);
                    break;
                case CHOICE_TWO:
                    purchasingLoop();
                    break;
                case CHOICE_THREE: // exit
                    printManager.printExitBanner();
                    System.exit(0);
            }
        }


    }

    private void purchasingLoop() {
        while (true) {
            String userPurchasingInput = "";
            do {
                printManager.printMenu(new PurchaseMenu(account), 1); // START USER AT PURCHASING MENU
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
                    printManager.printMenu(new FinishingMenu(account), 2);
                    account.setBalanceToZero();
                    return;
            }
        }
    }

    private void dispensingLoop() {
        String userDispensingInput = "";
        printManager.printMenu(new DisplayItemMenu(inventoryManager), 7);
        do {
            printManager.printItemCodePrompt();
            userDispensingInput = userInputScanner.nextLine().toLowerCase();
        } while (!userDispensingInput.matches("[a-zA-z]{1}[1-9]{1}"));

        for (Slot slot : inventoryManager.getInventory()) {
            if (userDispensingInput.equals(slot.getLocation().toLowerCase())) {
                if (slot.getProductRemaining() > 0) {
                    if (account.getBalance().compareTo(slot.getProductInSlot().getPrice()) >= 0) {
                        printManager.printDispenseMessage(slot);
                        // next line is doing 2 things -> actually deducting from the account AND storing amount deducted in variable
                        BigDecimal amountToDeduct = account.deductFromBalance(slot.getProductInSlot().getPrice());
                        inventoryManager.dispenseInventory(slot);
                        log.logPurchase(slot.getProductInSlot().getProductName() + " " + slot.getLocation(), amountToDeduct, account.getBalance());
                    } else {
                        printManager.printInsufficientFundsMessage();
                    }
                } else {
                    printManager.printSoldOutProductMessage();
                }
                return;
            }
        }
        printManager.printInvalidProductCodeMessage();
    }


    private void feedMoney() {
        int moneyToAdd;
        while (true) {
            printManager.printFeedMoneyPrompt();
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
