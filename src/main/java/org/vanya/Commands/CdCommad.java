package org.vanya.Commands;

import org.vanya.Singletons.CurrentPath;
import org.vanya.Singletons.SendBuffer;

import java.io.File;

//realization of cd command
public class CdCommad implements Command {

    private String parameters;

    /**
     *
     * @param parameters value of path
     */
    public CdCommad(String parameters) {
        this.parameters = parameters;
    }

    public CdCommad() {

    }

    /**
     * Change current path on path that setup in parameter
     */
    @Override
    public void execute() {
        //TODO: remake it latter
        String newCurrentPath = "";
        File file;
        if (!parameters.equals("..")) {
            int length = CurrentPath.getInstance().getCurrentPath().length();
            if (CurrentPath.getInstance().getCurrentPath().charAt(length - 1) == '/') {
                newCurrentPath = CurrentPath.getInstance().getCurrentPath() + parameters;
                file = new File(newCurrentPath);
                if (file.isDirectory()) {
                    CurrentPath.getInstance().setCurrentPath(newCurrentPath);
                    SendBuffer.getInstance().setMessage("Current path is " + CurrentPath.getInstance().getCurrentPath());
                } else SendBuffer.getInstance().setMessage("Error!");
            } else {
                newCurrentPath = CurrentPath.getInstance().getCurrentPath() + "/" + parameters;
                file = new File(newCurrentPath);
                if (file.isDirectory()) {
                    CurrentPath.getInstance().setCurrentPath(newCurrentPath);
                    SendBuffer.getInstance().setMessage("Current path is " + CurrentPath.getInstance().getCurrentPath());
                } else SendBuffer.getInstance().setMessage("Error!");
            }
        } else {
            String currentPath = CurrentPath.getInstance().getCurrentPath();

            String[] currentPathSplited = currentPath.split("/");
            for (int i = 0; i < (currentPathSplited.length - 1); i++) {
                newCurrentPath += currentPathSplited[i] + "/";
            }
            CurrentPath.getInstance().setCurrentPath(newCurrentPath);
            SendBuffer.getInstance().setMessage("Current path is " + CurrentPath.getInstance().getCurrentPath());
        }

        //LastCommand.getInstance().setLastCommand(SendBuffer.getInstance().getMessage());
    }


}
