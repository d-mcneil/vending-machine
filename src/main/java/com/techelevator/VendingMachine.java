package com.techelevator;

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
//    private Menu purchaseMenu = new PurchaseMenu();
    private String userInput = "";
    private final String CHOICE_ONE = "1";
    private final String CHOICE_TWO = "2";
    private final String CHOICE_THREE = "3";

    public void run() {
        // Welcome message
        System.out.println("************************************************");
        System.out.println("* Welcome to Dean and Michel's Vending Machine *");
        System.out.println("************************************************");
        System.out.println();



        do {
            // Start user at main menu
            mainMenu.displayMenu();
            userInput = userInputScanner.nextLine();
        } while (!userInput.equals(CHOICE_ONE) && !userInput.equals(CHOICE_TWO) && !userInput.equals(CHOICE_THREE));

        switch (userInput) {
            case CHOICE_ONE:
                displayItemMenu.displayMenu();
                break;
            case CHOICE_TWO:
//                purchaseMenu.displayMenu(); todo: uncomment and complete
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
