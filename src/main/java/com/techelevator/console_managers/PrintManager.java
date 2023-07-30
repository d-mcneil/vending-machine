package com.techelevator.console_managers;

import com.techelevator.CustomConstants;
import com.techelevator.Menus.Menu;
import com.techelevator.inventory.Slot;

public class PrintManager {
    public void printBanner(String message, int characterOffset) {
        int messageLength = message.length();
        System.out.println();
        System.out.println(CustomConstants.starChar.repeat(messageLength - characterOffset));
        System.out.print(CustomConstants.starChar + " ");
        System.out.print(message);
        System.out.println(" " + CustomConstants.starChar);
        System.out.println(CustomConstants.starChar.repeat(messageLength - characterOffset));
    }

    public void printWelcomeBanner() {
        printBanner(CustomConstants.welcomeMessage, 8);
    }

    public void printExitBanner() {
        printBanner(CustomConstants.exitMessage, 10);
    }

    public void printMenu (Menu menu, int characterOffset) {
        System.out.println();
        System.out.println();
        printBanner(menu.getMenuMessage(), characterOffset);
        System.out.println();
        for (String option : menu.getMenuOptions()) {
            System.out.println(option);
        }
        System.out.println();
        if (menu.getPostMessage() != null) {
            System.out.print(menu.getPostMessage());
            if (menu.isCommandLinePrompt()) {
                System.out.print(" ---> ");
            } else {
                System.out.println();
            }
        }
    }

    public void printDispenseMessage(Slot slot) {
        printMessage(slot.getProductInSlot().getDispenseMessage());
    }

    public void printItemCodePrompt() {
        printCommandPrompt("Enter the code for the item you wish to purchase");
    }

    public void printFeedMoneyPrompt() {
        printCommandPrompt("Enter the amount of money to add in whole dollar amounts");
    }

    public void printInvalidProductCodeMessage() {
        printMessage("Sorry, that isn't a valid product code.");
    }

    public void printSoldOutProductMessage() {
        printMessage("Sorry, that product is sold out.");
    }

    public void printInsufficientFundsMessage() {
        printMessage("Sorry, you haven't fed in enough money to purchase that item. Please add more money.");
    }

    public void printCommandPrompt(String prompt) {
        System.out.println();
        System.out.println();
        System.out.print(CustomConstants.starChar + " " + prompt + " ---> ");
    }

    public void printMessage(String message) {
        System.out.println();
        System.out.println();
        System.out.println(message);
    }
}
