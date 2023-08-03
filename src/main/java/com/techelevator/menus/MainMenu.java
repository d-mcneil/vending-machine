package com.techelevator.menus;

import com.techelevator.Constants;

public class MainMenu extends Menu {
    public MainMenu() {
        super(
                Constants.MAIN_MENU_MESSAGE,
                Constants.MAIN_MENU_OPTIONS,
                // 1 = Display Vending Machine Items
                // 2 = Purchase
                // 3 = Exit
                Constants.MAIN_MENU_POST_MESSAGE,
                true
        );
    }
}
