package by.training.xmlparser.entity;

public enum Tariffing {
    MINUTE_QUARTER("0.25"),
    MINUTE_HALF("0.5"),
    MINUTE_FULL("1");

    private String value;

    Tariffing(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Tariffing getTariffingTypeByValue(String value) {
        Tariffing[] values = Tariffing.values();
        for (Tariffing tariffing : values) {
            if (tariffing.getValue().equals(value)) {
                return tariffing;
            }
        }
        throw new IllegalArgumentException();
    }
}
