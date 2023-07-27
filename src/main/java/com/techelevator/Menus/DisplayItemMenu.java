package com.techelevator.Menus;

import com.techelevator.inventory.InventoryManager;
import com.techelevator.inventory.Slot;

public class DisplayItemMenu extends MenuParent
{
    public DisplayItemMenu(InventoryManager inventoryManager)
    {
        super(menuOptions, menuMessage);
    }


//    InventoryManager inventoryManager = new InventoryManager();
//    for(Slot slot : inventoryManager.getInventory()) {}
    // slotnumber slot.getLocation
    // name slot.getProductInSlot().getProductName()
    // price slot.getProductInSlot().getPrice()
    //whole inventory


    // displayed when item is chosen
//    System.out.println(slot.getProductInSlot().getDispenseMessage());



}

    @Override
    public void displayMenu() {

    }
}
