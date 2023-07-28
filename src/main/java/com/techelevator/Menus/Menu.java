package com.techelevator.Menus;

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

//    @Override
//    public String getMenuDisplayString() {
//        StringBuilder stringBuilder = new StringBuilder("\n\n");
//        stringBuilder.append(this.menuMessage);
//        stringBuilder.append("\n\n");
//        for (String option : this.menuOptions) {
//            stringBuilder.append(option);
//            stringBuilder.append("\n");
//        }
//        stringBuilder.append("\n");
//        if (postMessage != null) {
//            stringBuilder.append(this.postMessage);
//            if (this.isCommandLinePrompt) {
//                stringBuilder.append(" >>>> ");
//            }
//        }
//        return stringBuilder.toString();
//    }
}
