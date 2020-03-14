package by.training.xmlparser.parser.dom;

import by.training.xmlparser.builder.AbstractTariffBuilder;
import by.training.xmlparser.builder.CallPriceBuilder;
import by.training.xmlparser.builder.ParametersBuilder;
import by.training.xmlparser.builder.TariffEnum;
import by.training.xmlparser.entity.CallPrice;
import by.training.xmlparser.entity.Parameters;
import by.training.xmlparser.entity.Tariff;
import by.training.xmlparser.entity.Tariffing;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class DOMBuilder extends AbstractTariffBuilder {
    private static final Logger logger = Logger.getLogger(DOMBuilder.class);
    private DocumentBuilder documentBuilder;

    public DOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
        }
    }

    @Override
    public void buildTariffs(InputStream source){
        Document document;
        try {
            document = documentBuilder.parse(source);
            Element root = document.getDocumentElement();
            NodeList touristVoucher = root.getElementsByTagName(TariffEnum.TARIFF.getValue());

            for (int i = 0; i < touristVoucher.getLength(); i++) {
                Element touristVoucherElement = (Element) touristVoucher.item(i);
                Tariff example = buildTariff(touristVoucherElement);
                tariffs.add(example);
            }
        } catch (SAXException | IOException e) {
            logger.error(e);
        }
    }

    private Tariff buildTariff(Element element){
        CallPriceBuilder callPriceBuilder = new CallPriceBuilder()
                .buildPriceWithinNetwork(Double.parseDouble(getElementTextContent(element,
                        TariffEnum.WITHIN_NETWORK.getValue())))
                .buildPriceInOtherNetworks(Double.parseDouble(getElementTextContent(element,
                        TariffEnum.OTHER_NETWORK.getValue())))
                .buildPriceForStandardPhoneNumbers(Double.parseDouble(getElementTextContent(element,
                        TariffEnum.STANDARD_PHONE_NUMBERS.getValue())));

        ParametersBuilder parametersBuilder = new ParametersBuilder()
                .buildContainsFavouritePhoneNumbers(Boolean.parseBoolean(getElementTextContent(element,
                        TariffEnum.CONTAINS_FAVOURITE_NUMBERS.getValue())))
                .buildTariffing(Tariffing.getTariffingTypeByValue(getElementTextContent(element,
                        TariffEnum.TARIFFING.getValue())))
                .setConnectionCost(Double.parseDouble(getElementTextContent(element,
                        TariffEnum.CONNECTION_COST.getValue())));
        AbstractTariffBuilder builder = new DOMBuilder()
                .buildName(getElementTextContent(element, TariffEnum.NAME.getValue()))
                .buildOperatorName(getElementTextContent(element, TariffEnum.OPERATOR_NAME.getValue()))
                .buildSmsPrice(Double.parseDouble(getElementTextContent(element,
                        TariffEnum.SMS_PRICE.getValue())))
                .buildPayroll(Double.parseDouble(getElementTextContent(element,
                        TariffEnum.PAYROLL.getValue())))
                .buildCallPrice(new CallPrice(callPriceBuilder))
                .buildParameters(new Parameters(parametersBuilder));
        return new Tariff(builder);
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
