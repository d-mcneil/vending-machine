package com.techelevator.menus;

public class MainMenu extends Menu
{
    public MainMenu()
    {
        super(
                new String[]{"(1) Display Vending Machine Items", "(2) Purchase", "(3) Exit"}
                ,"Main Menu",
                "Select An Option (1/2/3)", true
        );
    }
}
