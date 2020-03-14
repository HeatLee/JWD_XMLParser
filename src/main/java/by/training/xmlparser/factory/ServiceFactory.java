package by.training.xmlparser.factory;

import by.training.xmlparser.service.ParserService;
import by.training.xmlparser.service.impl.DOMParserService;
import by.training.xmlparser.service.impl.SAXParserService;
import by.training.xmlparser.service.impl.STAXParserService;

public enum ServiceFactory {
    INSTANCE;
    private ParserService domParserService = new DOMParserService();
    private ParserService saxParserService = new SAXParserService();
    private ParserService staxParserService = new STAXParserService();

    public ParserService getDOMParserService() {
        return domParserService;
    }

    public ParserService getSAXParserService() {
        return saxParserService;
    }

    public ParserService getSTAXParserService() {
        return staxParserService;
    }
}
