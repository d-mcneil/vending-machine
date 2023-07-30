package com.techelevator;

import com.techelevator.Accounting.Account;
import com.techelevator.Items.Item;
import com.techelevator.Menus.*;
import com.techelevator.Menus.Menu;
import com.techelevator.Reports.Logger;
import com.techelevator.console_managers.PrintManager;
import com.techelevator.inventory.InventoryManager;
import com.techelevator.inventory.Slot;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {
    // Pull in constants from CustomConstants class
    private final String CHOICE_ONE = CustomConstants.CHOICE_ONE;
    private final String CHOICE_TWO = CustomConstants.CHOICE_TWO;
    private final String CHOICE_THREE = CustomConstants.CHOICE_THREE;
    private final String GIVE_CHANGE = CustomConstants.GIVE_CHANGE;
    private final String FEED_MONEY = CustomConstants.FEED_MONEY;
    private final int DISPLAY_ITEM_MENU_CHARACTER_OFFSET = CustomConstants.DISPLAY_ITEM_MENU_CHARACTER_OFFSET;
    private final int MAIN_MENU_CHARACTER_OFFSET = CustomConstants.MAIN_MENU_CHARACTER_OFFSET;
    private final int PURCHASE_MENU_CHARACTER_OFFSET = CustomConstants.PURCHASE_MENU_CHARACTER_OFFSET;
    private final int FINISHING_MENU_CHARACTER_OFFSET = CustomConstants.FINISHING_MENU_CHARACTER_OFFSET;
    private final String PRODUCT_CODE_REGEX_EXPRESSION = CustomConstants.PRODUCT_CODE_REGEX_EXPRESSION;
    private final String INVENTORY_FILE_PATH = CustomConstants.INVENTORY_FILE_PATH;

    // Initialize
    private final Scanner userInputScanner = new Scanner(System.in);
    private final PrintManager printManager = new PrintManager();
    private final InventoryManager inventoryManager = new InventoryManager(INVENTORY_FILE_PATH);
    private final Account account = new Account();
    private final Logger log = new Logger();


    public void run() {
        printManager.printWelcomeBanner();

        while (true) { // MAIN MENU LOOP
            String userInput;
            do {
                printManager.printMenu(new MainMenu(), MAIN_MENU_CHARACTER_OFFSET);
                userInput = userInputScanner.nextLine();
            } while (!userInput.equals(CHOICE_ONE)
                    && !userInput.equals(CHOICE_TWO)
                    && !userInput.equals(CHOICE_THREE)
            );

            // 1 = Display Vending Machine Items
            // 2 = Purchase
            // 3 = Exit

            switch (userInput) {
                case CHOICE_ONE:
                    printManager.printMenu(new DisplayItemMenu(inventoryManager), DISPLAY_ITEM_MENU_CHARACTER_OFFSET);
                    break;
                case CHOICE_TWO:
                    purchasingLoop();
                    break;
                case CHOICE_THREE:
                    printManager.printExitBanner();
                    System.exit(0);
            }
        }
    }

    private void purchasingLoop() {
        while (true) {
            String userPurchasingInput;
            do {
                printManager.printMenu(new PurchaseMenu(account), PURCHASE_MENU_CHARACTER_OFFSET);
                userPurchasingInput = userInputScanner.nextLine();
            } while (!userPurchasingInput.equals(CHOICE_ONE)
                    && !userPurchasingInput.equals(CHOICE_TWO)
                    && !userPurchasingInput.equals(CHOICE_THREE)
            );

            // 1 = Feed Money
            // 2 = Select Product
            // 3 = Finish Transaction

            switch (userPurchasingInput) {
                case CHOICE_ONE:
                    feedMoneyLoop();
                    break;
                case CHOICE_TWO:
                    dispensingLoop();
                    break;
                case CHOICE_THREE:
                    log.logPurchase(GIVE_CHANGE, account.getBalance(), BigDecimal.ZERO);
                    printManager.printMenu(new FinishingMenu(account), FINISHING_MENU_CHARACTER_OFFSET);
                    account.setBalanceToZero();
                    return;
            }
        }
    }

    private void dispensingLoop() {
        String userDispensingInput;
        printManager.printMenu(new DisplayItemMenu(inventoryManager), DISPLAY_ITEM_MENU_CHARACTER_OFFSET);
        do {
            printManager.printItemCodePrompt();
            userDispensingInput = userInputScanner.nextLine().toLowerCase();
            if(!userDispensingInput.matches(PRODUCT_CODE_REGEX_EXPRESSION))
            {
                printManager.printInvalidProductCodeMessage();
            }
        } while (!userDispensingInput.matches(PRODUCT_CODE_REGEX_EXPRESSION));



        for (Slot slot : inventoryManager.getInventory()) {
            String slotLocation = slot.getLocation();
            Item slotProduct = slot.getProductInSlot();
            BigDecimal productPrice = slotProduct.getPrice();

            if (!userDispensingInput.equals(slotLocation.toLowerCase())) {
                continue;
            }
            if (slot.getProductRemaining() == 0) {
                printManager.printSoldOutProductMessage();
                return;
            }
            if (account.getBalance().compareTo(productPrice) == -1) {
                printManager.printInsufficientFundsMessage();
                return;
            }
            printManager.printDispenseMessage(slot);
            // next line is doing 2 things -> actually deducting from the account AND storing amount deducted in variable
            BigDecimal amountToDeduct = account.deductFromBalance(productPrice);
            inventoryManager.dispenseInventory(slot);
            log.logPurchase(slotProduct.getProductName() + " " + slotLocation, amountToDeduct, account.getBalance());
            return;
        }
            printManager.printInvalidProductCodeMessage();


    }


    private void feedMoneyLoop() {
        int moneyToAdd;
        while (true) {
            printManager.printFeedMoneyPrompt();
            if (userInputScanner.hasNextInt()) {
                moneyToAdd = Integer.parseInt(userInputScanner.nextLine());
                if (moneyToAdd > 0) {
                    account.feedMoney(moneyToAdd);
                    log.logPurchase(FEED_MONEY, BigDecimal.valueOf(moneyToAdd), account.getBalance());
                    break;
                }
            } else {
                userInputScanner.nextLine();
            }
        }
    }
}
