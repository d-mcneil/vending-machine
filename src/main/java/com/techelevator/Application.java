package com.techelevator;

import com.techelevator.Menus.DisplayItemMenu;
import com.techelevator.Menus.MainMenu;
import com.techelevator.inventory.InventoryManager;
import com.techelevator.inventory.Slot;


public class Application {
    public static void main(String[] args) {
//        InventoryManager inventoryManager = new InventoryManager();
//        MainMenu mainMenu = new MainMenu();
//        DisplayItemMenu displayItemsMenu = new DisplayItemMenu(inventoryManager);
//
//        for (Slot slot : inventoryManager.getInventory()) {
//            System.out.println(slot.getProductInSlot().getProductName());
//            System.out.println(slot.getProductInSlot().getDispenseMessage());
//            System.out.println(slot.getLocation());
//            System.out.println(slot.getProductInSlot().getPrice());
//            System.out.println(slot.getProductInSlot().getProductType());
//            System.out.println();
//        }
//
//        mainMenu.displayMenu();
//        displayItemsMenu.displayMenu();

        new VendingMachine().run();

    }
}
