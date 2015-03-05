package org.vanya.Commands;

import java.io.FileNotFoundException;

/**
 * Interface that must be implemented by commands
 */
public interface Command {
    //use for execute command after it will be created by creator

    /**
     * Method used for execute command after it will be created by creator
     *
     * @throws FileNotFoundException
     */
    public void execute() throws FileNotFoundException;
}
