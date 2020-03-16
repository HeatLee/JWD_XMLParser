package by.training.xmlparser.parser.sax;

import by.training.xmlparser.builder.TariffEnum;
import by.training.xmlparser.entity.CallPrice;
import by.training.xmlparser.entity.Parameters;
import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.entity.Tariffing;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class SAXHandler extends DefaultHandler {
    private Set<Tariff> tariffSet;
    private Tariff current;
    private TariffEnum currentTag;

    public SAXHandler() {
        tariffSet = new HashSet<>();
    }

    public Set<Tariff> getTariffSet() {
        return tariffSet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        if (TariffEnum.TARIFF.getValue().equals(localName)) {
            current = new Tariff();
            current.setParameters(new Parameters());
            current.setCallPrice(new CallPrice());
        } else {
            currentTag = TariffEnum.getTagTypeByValue(localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if (TariffEnum.TARIFF.getValue().equals(localName)) {
            tariffSet.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tagValue = new String(ch, start, length).trim();
        if (currentTag != null) {

            switch (currentTag) {
                case NAME:
                    current.setName(tagValue);
                    break;
                case OPERATOR_NAME:
                    current.setOperatorName(tagValue);
                    break;
                case SMS_PRICE:
                    current.setSMSPrice(Double.parseDouble(tagValue));
                    break;
                case PAYROLL:
                    current.setPayroll(Double.parseDouble(tagValue));
                    break;
                case TARIFFING:
                    current.getParameters().setTariffing(Tariffing.getTariffingTypeByValue(tagValue));
                    break;
                case CONTAINS_FAVOURITE_NUMBERS:
                    current.getParameters().setContainsFavouritePhoneNumbers(Boolean.parseBoolean(tagValue));
                    break;
                case CONNECTION_COST:
                    current.getParameters().setConnectionCost(Double.parseDouble(tagValue));
                    break;
                case WITHIN_NETWORK:
                    current.getCallPrice().setWithinNetworkPrice(Double.parseDouble(tagValue));
                    break;
                case OTHER_NETWORK:
                    current.getCallPrice().setOtherNetworkPrice(Double.parseDouble(tagValue));
                    break;
                case STANDARD_PHONE_NUMBERS:
                    current.getCallPrice().setStandardPhoneNumbersPrice(Double.parseDouble(tagValue));
                case TARIFF:
                case TARIFFS:
                case PARAMETERS:
                case CALL_PRICES:
                    break;
                default:
                    throw new SAXException("Invalid tag");
            }
        }
        currentTag = null;
    }
}
