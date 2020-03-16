package by.training.xmlparser.factory;

import by.training.xmlparser.command.Command;
import by.training.xmlparser.command.CommandParameter;

public class CommandFactory {
    public Command getCommand(String commandName) {
        return CommandParameter.valueOf(commandName).getCommand();
    }
}
