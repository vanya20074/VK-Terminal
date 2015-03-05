package org.vanya.Commands;

import java.io.FileNotFoundException;

/**
 * Created by vanya on 01.03.15.
 */
public interface Command {
    public void execute() throws FileNotFoundException;
}
