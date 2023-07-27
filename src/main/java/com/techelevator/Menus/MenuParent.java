package com.techelevator.Menus;

public abstract class MenuParent implements Displayable
{
    private String[] menuOptions;
    private String menuMessage;

    public MenuParent(String[] menuOptions, String menuMessage)
    {
        this.menuOptions = menuOptions;
        this.menuMessage = menuMessage;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public String getMenuMessage() {
        return menuMessage;
    }


}
