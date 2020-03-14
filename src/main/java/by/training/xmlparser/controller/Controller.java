package by.training.xmlparser.controller;

import by.training.xmlparser.command.Command;
import by.training.xmlparser.command.JSPParameter;
import by.training.xmlparser.command.Pages;
import by.training.xmlparser.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
@MultipartConfig(maxFileSize = 10240)
public class Controller extends HttpServlet {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Command command = COMMAND_FACTORY.getCommand(req.getParameter(JSPParameter.COMMAND.getValue()));
        String nextPagePath = command.execute(req, resp);
        req.getRequestDispatcher(nextPagePath).forward(req, resp);
    }
}
