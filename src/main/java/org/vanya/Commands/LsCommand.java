package org.vanya.Commands;

import org.vanya.Singletons.CurrentPath;
import org.vanya.Singletons.SendBuffer;

import java.io.File;

/**
 * Command that return file and catalog list
 */
public class LsCommand implements Command {

    private String parameters = null;

    public LsCommand(String parameters) {
        this.parameters = parameters;
    }

    public LsCommand() {
    }

    @Override
    public void execute() {
        File file = new File(CurrentPath.getInstance().getCurrentPath());
        String message = "";
        for (String tmp : file.list()) {
            message = message + "<br>" + tmp;

        }
        SendBuffer.getInstance().setMessage(message);

    }


}
