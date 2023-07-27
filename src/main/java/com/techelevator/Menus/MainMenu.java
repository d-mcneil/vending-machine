package com.techelevator.Menus;

public class MainMenu extends Menu
{
    // two submenus displayed >>  display items, and purchase
    //main menu displays exit


    public MainMenu()
    {
        super(new String[]{"(1) Display Vending Machine Items", "(2) Purchase", "(3) Exit"} ,"Select An Option: (1/2/3)");

    }

    @Override
    public void displayMenu()
    {
        System.out.println(this.getMenuMessage());
        System.out.println();
        for(String option : this.getMenuOptions())
        {
            System.out.println(option);
        }
        System.out.println();

    }
}
