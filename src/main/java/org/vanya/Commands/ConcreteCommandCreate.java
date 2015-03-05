package org.vanya.Commands;

/**
 * Command creator class
 */
public class ConcreteCommandCreate implements CommandCreator {
    /**
     * Command create method that used for command that needs parameters
     *
     * @param commandName name of command that must be created
     * @param parameters  parameters needed for command
     * @return
     */
    @Override
    public Command getCommand(String commandName, String parameters) {
        if(commandName.equals("cd")) return new CdCommad(parameters);
        if(commandName.equals("read")) return new ReadCommand(parameters);
        if(commandName.equals("exec")) return new ExecCommand(parameters);
        return null;
    }

    /**
     * Command create method that use for command without parameters
     *
     * @param commandName name of command that must be created
     * @return
     */
    @Override
    public Command getCommand(String commandName) {

        if(commandName.equals("ls")) return new LsCommand();
        return null;
    }
}
