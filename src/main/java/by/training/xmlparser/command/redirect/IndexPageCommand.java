package by.training.xmlparser.command.redirect;

import by.training.xmlparser.command.Command;
import by.training.xmlparser.command.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Pages.INDEX_JSP.getValue();
    }
}
