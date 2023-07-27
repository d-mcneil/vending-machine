package com.techelevator.Menus;

import com.techelevator.inventory.InventoryManager;

import java.util.stream.Collectors;

public class DisplayItemMenu extends Menu {
    public DisplayItemMenu(InventoryManager inventoryManager) {
        super(inventoryManager.getInventory()
                        .stream()
                        .map(slot ->
                                slot.getLocation()
                                        + "  "
                                        + slot.getProductInSlot().getPrice()
                                        + "  "
                                        + "Remaining: "
                                        + (slot.getProductRemaining() == 0
                                            ? "SOLD OUT"
                                            : slot.getProductRemaining()
                                                + " ".repeat("SOLD OUT".length() - String.valueOf(slot.getProductRemaining()).length())
                                        )
                                        + slot.getProductInSlot().getProductName()
                        )
                        .collect(Collectors.toList())
                        .toArray(new String[0])
                , "These are your options to choose from:"
        );
//        super(menuOptions, menuMessage);
    }


//    InventoryManager inventoryManager = new InventoryManager();
//    for(Slot slot : inventoryManager.getInventory()) {}
    // slotnumber slot.getLocation
    // name slot.getProductInSlot().getProductName()
    // price slot.getProductInSlot().getPrice()
    //whole inventory


    // TODO: displayed when item is chosen
//    System.out.println(slot.getProductInSlot().getDispenseMessage());


}
