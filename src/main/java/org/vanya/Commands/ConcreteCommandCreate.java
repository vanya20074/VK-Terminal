package org.vanya.Commands;

/**
 * Created by vanya on 01.03.15.
 */
public class ConcreteCommandCreate implements CommandCreator {
    @Override
    public Command getCommand(String commandName, String parameters) {
        if(commandName.equals("cd")) return new CdCommad(parameters);
        if(commandName.equals("read")) return new ReadCommand(parameters);
        if(commandName.equals("exec")) return new ExecCommand(parameters);
        return null;
    }

    @Override
    public Command getCommand(String commandName) {

        if(commandName.equals("ls")) return new LsCommand();
        return null;
    }
}
