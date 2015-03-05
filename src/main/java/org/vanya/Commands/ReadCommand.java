package org.vanya.Commands;

import org.vanya.Singletons.CurrentPath;
import org.vanya.Singletons.SendBuffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * command for read some file, work bad, need fix
 */
public class ReadCommand implements Command {

    private String parameters;

    public ReadCommand(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() throws FileNotFoundException {
        String fileData = "";
        File file = new File(CurrentPath.getInstance().getCurrentPath() + "/" + parameters);

        if (file.isFile()) {
            Scanner in = new Scanner(file);
            int i = 10;
            while (in.hasNext()) {
                fileData += in.nextLine() + "<br>";
                i--;
                if (i <= 0) break;
            }
            in.close();

            String message = fileData.replaceAll("/", "%2F");
            message = message.replaceAll("#", "%23");
            SendBuffer.getInstance().setMessage(message);

        }
        else {
            SendBuffer.getInstance().setMessage("File is a directory!");

        }
    }

}
