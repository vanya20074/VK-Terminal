package org.vanya.Commands;

/**
 * Created by vanya on 01.03.15.
 */
public interface CommandCreator {
    Command getCommand (String commandName, String parameters);
    Command getCommand (String commandName);
}
