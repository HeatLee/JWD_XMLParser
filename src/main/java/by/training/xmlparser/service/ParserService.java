package by.training.xmlparser.service;

import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.exception.ServiceException;
import by.training.xmlparser.validator.XMLValidator;

import javax.servlet.http.Part;
import java.util.Set;

public interface ParserService {
    XMLValidator VALIDATOR = new XMLValidator();

    Set<Tariff> parse(Part filePart) throws ServiceException;
}
