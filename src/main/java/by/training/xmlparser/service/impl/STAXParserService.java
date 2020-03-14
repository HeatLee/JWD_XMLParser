package by.training.xmlparser.service.impl;

import by.training.xmlparser.builder.AbstractTariffBuilder;
import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.exception.ServiceException;
import by.training.xmlparser.parser.stax.STAXBuilder;
import by.training.xmlparser.service.ParserService;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

public class STAXParserService implements ParserService {
    private final static Logger LOGGER = Logger.getLogger(STAXParserService.class);

    @Override
    public Set<Tariff> parse(Part filePart) throws ServiceException {
        try {
            AbstractTariffBuilder builder = new STAXBuilder();
            InputStream stream = filePart.getInputStream();
            VALIDATOR.validateXMLSchema(stream);
            builder.buildTariffs(stream);
            return builder.getTariffs();
        } catch (ParseException | IOException e) {
            LOGGER.warn(e);
            throw new ServiceException(e);
        }
    }
}
