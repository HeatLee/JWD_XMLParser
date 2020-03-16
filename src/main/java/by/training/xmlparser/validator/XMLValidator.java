package by.training.xmlparser.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class XMLValidator {
    private final static Logger LOGGER = Logger.getLogger(XMLValidator.class);
    private final static String XSD_FILE_NAME = "tariffs.xsd";

    public void validateXMLSchema(InputStream xmlFile) {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(getXSD());
            Validator validator = schema.newValidator();
            validator.validate((Source) xmlFile);
        } catch (IOException | SAXException e) {
            LOGGER.warn(e);
        }

    }

    private File getXSD() {
        return new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(XSD_FILE_NAME)).getPath());
    }
}
