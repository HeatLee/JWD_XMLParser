package by.training.xmlparser.parser.sax;

import by.training.xmlparser.builder.AbstractTariffBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;

public class SAXParser extends AbstractTariffBuilder {
    private static final Logger logger = Logger.getLogger(SAXParser.class);
    private SAXHandler saxHandler;
    private XMLReader reader;

    public SAXParser() {
        saxHandler = new SAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxHandler);
        } catch (SAXException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildTariffs(InputStream file) {
        try {
            reader.parse(new InputSource(file));
            tariffs.addAll(saxHandler.getTariffSet());
        } catch (IOException | SAXException e) {
            logger.error(e);
        }
    }
}
