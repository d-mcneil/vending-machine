package com.techelevator.Menus;

public abstract class Menu implements Displayable
{
    private String[] menuOptions;
    private String menuMessage;

    public Menu(String[] menuOptions, String menuMessage)
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

    @Override
    public String getMenuDisplayString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.menuMessage);
        stringBuilder.append("\n\n");
        for (String option : this.menuOptions) {
            stringBuilder.append(option);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
