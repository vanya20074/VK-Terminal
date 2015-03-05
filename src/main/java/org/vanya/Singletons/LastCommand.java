package org.vanya.Singletons;

/**
 * Created by vanya on 01.03.15.
 */
public class LastCommand {

    private String lastCommand = "usr";


    public String getLastCommand() {
        return lastCommand;
    }

    public void setLastCommand(String lastCommand) {
       // System.out.println("change state of lastCommand on: " + lastCommand);
        this.lastCommand = lastCommand;
    }

    private static LastCommand ourInstance = new LastCommand();

    public static LastCommand getInstance() {
        return ourInstance;
    }

    private LastCommand() {
    }
}
