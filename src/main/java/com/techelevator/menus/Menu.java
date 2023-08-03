package com.techelevator.menus;

public abstract class Menu {
    private final String menuMessage;
    private final String[] menuOptions;
    private String postMessage;
    private boolean isPostMessageACommandLinePrompt;

    public Menu(String menuMessage, String[] menuOptions, String postMessage, boolean isPostMessageACommandLinePrompt) {
        this(menuMessage, menuOptions);
        this.postMessage = postMessage;
        this.isPostMessageACommandLinePrompt = isPostMessageACommandLinePrompt;
    }

    public Menu(String menuMessage, String[] menuOptions) {
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

    public boolean isPostMessageACommandLinePrompt() {
        return isPostMessageACommandLinePrompt;
    }
}
