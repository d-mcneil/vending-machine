package com.techelevator.menus;

import com.techelevator.Constants;
import com.techelevator.inventory.InventoryManager;

public class DisplayItemMenu extends Menu {
    public DisplayItemMenu(InventoryManager inventoryManager) {
        super(
                Constants.DISPLAY_MENU_MESSAGE,
                inventoryManager.getInventoryOptionsAsDisplayStringArray()
        );
    }
}
