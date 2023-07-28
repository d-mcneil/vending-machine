package com.techelevator.Menus;

import com.techelevator.CustomConstants;
import com.techelevator.inventory.InventoryManager;

import java.util.stream.Collectors;

public class DisplayItemMenu extends Menu {
    public DisplayItemMenu(InventoryManager inventoryManager) {
        super(inventoryManager.getInventory()
                        .stream()
                        .map(slot ->
                                slot.getLocation()
                                        + "  $"
                                        + slot.getProductInSlot().getPrice()
                                        + "  "
                                        + "Remaining: "
                                        + (slot.getProductRemaining() == 0
                                            ? "SOLD OUT" // TODO: formatting for sold out
                                            : slot.getProductRemaining()
                                                + " ".repeat("SOLD OUT".length() - String.valueOf(slot.getProductRemaining()).length())
                                        )
                                        + slot.getProductInSlot().getProductName()
                        )
                        .collect(Collectors.toList())
                        .toArray(new String[0])
                , CustomConstants.DISPLAY_MENU_MESSAGE
        );
    }
}
