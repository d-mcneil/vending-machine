package com.techelevator.menus;

public abstract class Menu
{
    private final String[] menuOptions;
    private final String menuMessage;
    private String postMessage;
    private boolean isCommandLinePrompt;

    public Menu(String[] menuOptions, String menuMessage, String postMessage, boolean isCommandLinePrompt)
    {
        this.menuOptions = menuOptions;
        this.menuMessage = menuMessage;
        this.postMessage = postMessage;
        this.isCommandLinePrompt = isCommandLinePrompt;
    }

    public Menu(String[] menuOptions, String menuMessage)
    {
        this.menuOptions = menuOptions;
        this.menuMessage = menuMessage;
    }

    public String getMenuMessage() {
        return menuMessage;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public boolean isCommandLinePrompt() {
        return isCommandLinePrompt;
    }

}
