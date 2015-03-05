package org.vanya.Commands;

import org.vanya.Singletons.CurrentPath;
import org.vanya.Singletons.SendBuffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

//exec linux terminal command
public class ExecCommand implements Command {

    private String parameters;

    public ExecCommand(String parameters) {
        this.parameters=parameters;
    }

    @Override
    public void execute() throws FileNotFoundException {
        //exec(CurrentPath.getInstance().getCurrentPath());
        SendBuffer.getInstance().setMessage(exec("cd " + CurrentPath.getInstance().getCurrentPath() + " && " +parameters));
    }
    private static String exec(String command) {

        String[] cmd = {"/bin/sh", "-c", command};
        String message = "";
        // String[] cmd = {"/bin/sh", "-c", "cd .. && ls"};
        try {
            String line;

            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader bri = new BufferedReader
                    (new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader
                    (new InputStreamReader(p.getErrorStream()));
            while ((line = bri.readLine()) != null) {
                System.out.println(line);
                message += "<br>" + line;
            }
            bri.close();
            p.waitFor();
            message += "<br>=====<br>Done!";
        } catch (Exception err) {
            err.printStackTrace();
        }
        return message;
    }
}
