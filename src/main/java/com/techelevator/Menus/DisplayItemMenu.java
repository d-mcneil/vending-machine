package com.techelevator.Menus;

import com.techelevator.CustomConstants;
import com.techelevator.inventory.InventoryManager;

public class DisplayItemMenu extends Menu {
    public DisplayItemMenu(InventoryManager inventoryManager) {
        super(
                inventoryManager.getInventoryOptionsAsDisplayStringArray()
                , CustomConstants.DISPLAY_MENU_MESSAGE
        );
    }
}
