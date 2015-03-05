package org.vanya.Commands;

import java.io.FileNotFoundException;

/**
 * Created by vanya on 01.03.15.
 */
public interface Command {
    //use for execute command after it will be created by creator
    public void execute() throws FileNotFoundException;
}
