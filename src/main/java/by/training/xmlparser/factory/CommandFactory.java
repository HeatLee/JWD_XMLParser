package by.training.xmlparser.factory;

import by.training.xmlparser.command.Command;
import by.training.xmlparser.command.CommandParameter;
import by.training.xmlparser.command.JSPParameter;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    public Command defineCommand(HttpServletRequest request) {
        return CommandParameter.valueOf(request.getParameter(JSPParameter.COMMAND.getValue())).getCommand();
    }

    public Command getCommand(String commandName) {
        return CommandParameter.valueOf(commandName).getCommand();
    }
}
