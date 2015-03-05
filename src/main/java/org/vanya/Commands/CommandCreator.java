package org.vanya.Commands;

/**
 * Interface for implemeted by creator
 */
public interface CommandCreator {
    Command getCommand (String commandName, String parameters);
    Command getCommand (String commandName);
}
