package by.training.xmlparser.service.impl;

import by.training.xmlparser.builder.AbstractTariffBuilder;
import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.exception.ServiceException;
import by.training.xmlparser.parser.dom.DOMParser;
import by.training.xmlparser.service.ParserService;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class DOMParserService implements ParserService {
    private static final Logger LOGGER = Logger.getLogger(DOMParserService.class);

    @Override
    public Set<Tariff> parse(Part filePart) throws ServiceException{
        try {
            AbstractTariffBuilder builder = new DOMParser();
            InputStream stream = filePart.getInputStream();
            VALIDATOR.validateXMLSchema(stream);
            builder.buildTariffs(stream);
            return builder.getTariffs();
        } catch (IOException e ) {
            LOGGER.warn(e);
            throw new ServiceException(e);
        }
    }
}
