package com.techelevator;

public class Constants {
    public static final String INVENTORY_FILE_PATH = "inventory_files/main.csv";
    // public static final String INVENTORY_FILE_PATH = "inventory_files/alternate.csv";
    // public static final String INVENTORY_FILE_PATH = "inventory_files/problem.csv";

    // ******************************** ITEMS ********************************
    public static final String CANDY = "Candy";
    public static final String DRINK = "Drink";
    public static final String MUNCHY = "Munchy";
    public static final String GUM = "Gum";
    public static final String CANDY_DISPENSE_MESSAGE = "Yummy Yummy, So Sweet!";
    public static final String DRINK_DISPENSE_MESSAGE = "Glug Glug, Yum!";
    public static final String MUNCHY_DISPENSE_MESSAGE = "Crunch Crunch, Yum!";
    public static final String GUM_DISPENSE_MESSAGE = "Chew Chew, Yum!";

    // ******************************** MENUS ********************************
    public static final int DISPLAY_ITEM_MENU_CHARACTER_OFFSET = 7;
    public static final int MAIN_MENU_CHARACTER_OFFSET = -1;
    public static final int PURCHASE_MENU_CHARACTER_OFFSET = 1;
    public static final int FINISHING_MENU_CHARACTER_OFFSET = 2;
    public static final String MENU_CHAR = "☆";
    public static final String WELCOME_MESSAGE = "Welcome to Dean and Michel's Vending Machine";
    public static final String EXIT_MESSAGE = "Thanks for Using Dean and Michel's Vending Machine";
    public static final String FINISHING_MENU_MESSAGE = "Transaction Completed";
    public static final String FINISHING_MENU_POST_MESSAGE = "Your new balance is $0.00";
    public static final String DISPLAY_MENU_MESSAGE = "These are your options to choose from:"; // TODO - remove colon?

    // ******************************** USER INPUT ********************************
    public static final String CHOICE_ONE = "1";
    public static final String CHOICE_TWO = "2";
    public static final String CHOICE_THREE = "3";
    public static final String PRODUCT_CODE_REGEX_EXPRESSION = "[a-zA-z]{1}[1-9]{1}";

    // ******************************** LOGGER ********************************
    public static final String GIVE_CHANGE = "GIVE CHANGE:";
    public static final String FEED_MONEY = "FEED MONEY:";




}
