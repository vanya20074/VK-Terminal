package org.vanya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vanya.Commands.Command;
import org.vanya.Commands.CommandCreator;
import org.vanya.Commands.ConcreteCommandCreate;

/**
 * @author vanya20074
 */
public class CommandTest {


    public static void main(String[] args) throws Exception {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");

        Request request = (Request) context.getBean("requestBean");
        Response response = (Response) context.getBean("responseBean");

        CommandCreator commandCreator = new ConcreteCommandCreate();

        String commandLine = "";
        String recievedCommandLine;
        while (true) {

            recievedCommandLine = request.getRequest();

            String parameters = null;
            String[] commandLineSplited = recievedCommandLine.split(" ");
            Command command = null;
            if (commandLineSplited.length == 2) {
                commandLine = commandLineSplited[0];
                parameters = commandLineSplited[1];
                command = commandCreator.getCommand(commandLine, parameters);
            } else if(commandLineSplited.length > 2) {
                commandLine = commandLineSplited[0];
                parameters = recievedCommandLine.replaceFirst(commandLine, "");
                parameters = parameters.replaceAll("&amp;", "&");
                command = commandCreator.getCommand(commandLine, parameters);
            }  else {
                command = commandCreator.getCommand(recievedCommandLine);
            }
            if (command != null) {
                command.execute();
                response.sendMessageBack();
            }
            Thread.sleep(3000);
        }
    }
}
