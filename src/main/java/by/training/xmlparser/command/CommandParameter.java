package by.training.xmlparser.command;

import by.training.xmlparser.command.redirect.DOMCommand;
import by.training.xmlparser.command.redirect.SAXCommand;
import by.training.xmlparser.command.redirect.STAXCommand;

public enum CommandParameter {
    DOM_PARSE(new DOMCommand()),
    SAX_PARSE(new SAXCommand()),
    STAX_PARSE(new STAXCommand());

    Command command;

    CommandParameter(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
