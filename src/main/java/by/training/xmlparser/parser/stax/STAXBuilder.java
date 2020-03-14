package by.training.xmlparser.parser.stax;

import by.training.xmlparser.builder.AbstractTariffBuilder;
import by.training.xmlparser.builder.TariffEnum;
import by.training.xmlparser.entity.CallPrice;
import by.training.xmlparser.entity.Parameters;
import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.entity.Tariffing;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.text.ParseException;

public class STAXBuilder extends AbstractTariffBuilder {
    private static final Logger logger = Logger.getLogger(STAXBuilder.class);
    private static final int ID_ATTRIBUTE_POSITION = 0;
    private XMLInputFactory inputFactory;

    public STAXBuilder() {
        inputFactory = XMLInputFactory.newFactory();
    }

    @Override
    public void buildTariffs(InputStream file) throws ParseException {
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(file);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    if (TariffEnum.getTagTypeByValue(reader.getLocalName()) == TariffEnum.TARIFF) {
                        Tariff tariff = getXMLTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error(e);
        }
    }

    private Tariff getXMLTariff(XMLStreamReader reader) throws XMLStreamException {
        Tariff tariff = new Tariff();
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (TariffEnum.getTagTypeByValue(reader.getLocalName())) {
                        case NAME:
                            tariff.setName(getXMLText(reader));
                            break;
                        case OPERATOR_NAME:
                            tariff.setOperatorName(getXMLText(reader));
                            break;
                        case PAYROLL:
                            tariff.setPayroll(Double.parseDouble(getXMLText(reader)));
                            break;
                        case SMS_PRICE:
                            tariff.setSMSPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                        case CALL_PRICES:
                            tariff.setCallPrice(getXMLCallPrices(reader));
                            break;
                        case PARAMETERS:
                            tariff.setParameters(getXMLParameters(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (TariffEnum.getTagTypeByValue(reader.getLocalName()) == TariffEnum.TARIFF) {
                        return tariff;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unsupported element within tariff tag");
    }

    private Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException {
        Parameters parameters = new Parameters();
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (TariffEnum.getTagTypeByValue(reader.getLocalName())) {
                        case TARIFFING:
                            parameters.setTariffing(Tariffing.getTariffingTypeByValue(getXMLText(reader)));
                            break;
                        case CONNECTION_COST:
                            parameters.setConnectionCost(Double.parseDouble(getXMLText(reader)));
                            break;
                        case CONTAINS_FAVOURITE_NUMBERS:
                            parameters.setContainsFavouritePhoneNumbers(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (TariffEnum.getTagTypeByValue(reader.getLocalName()) == TariffEnum.PARAMETERS) {
                        return parameters;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unsupported element within parameters tag");
    }

    private CallPrice getXMLCallPrices(XMLStreamReader reader) throws XMLStreamException {
        CallPrice callPrice = new CallPrice();
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (TariffEnum.getTagTypeByValue(reader.getLocalName())) {
                        case WITHIN_NETWORK:
                            callPrice.setWithinNetworkPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                        case OTHER_NETWORK:
                            callPrice.setOtherNetworkPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                        case STANDARD_PHONE_NUMBERS:
                            callPrice.setStandardPhoneNumbersPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (TariffEnum.getTagTypeByValue(reader.getLocalName()) == TariffEnum.CALL_PRICES) {
                        return callPrice;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unsupported element within callPrice tag");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = "";
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }

        return text;
    }
}
