package org.vanya.Singletons;

/**
 * Stored last recieved message
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
