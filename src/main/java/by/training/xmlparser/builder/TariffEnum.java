package by.training.xmlparser.builder;

import by.training.xmlparser.entity.Tariff;

public enum TariffEnum {
    TARIFFS("tariffs"),
    TARIFF("tariff"),
    NAME("name"),
    OPERATOR_NAME("operatorName"),
    PAYROLL("payroll"),
    CALL_PRICES("callPrices"),
    SMS_PRICE("SMSPrice"),
    PARAMETERS("parameters"),
    WITHIN_NETWORK("withinNetwork"),
    OTHER_NETWORK("otherNetwork"),
    STANDARD_PHONE_NUMBERS("standardPhoneNumbers"),
    CONTAINS_FAVOURITE_NUMBERS("isFavouritePhoneNumber"),
    TARIFFING("tariffing"),
    CONNECTION_COST("connectionCost");

    private String value;

    TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
