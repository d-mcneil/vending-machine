package com.techelevator.menus;

import com.techelevator.Constants;

public class MainMenu extends Menu {
    public MainMenu() {
        super(
                Constants.MAIN_MENU_MESSAGE,
                Constants.MAIN_MENU_OPTIONS,
                Constants.MAIN_MENU_POST_MESSAGE,
                true
        );
    }
}
