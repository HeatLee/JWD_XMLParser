package by.training.xmlparser.builder;

import by.training.xmlparser.entity.Tariffing;

public class ParametersBuilder {
    private boolean containsFavouritePhoneNumbers;
    private Tariffing tariffing;
    private double connectionCost;

    public boolean isContainsFavouritePhoneNumbers() {
        return containsFavouritePhoneNumbers;
    }

    public ParametersBuilder buildContainsFavouritePhoneNumbers(boolean containsFavouritePhoneNumbers) {
        this.containsFavouritePhoneNumbers = containsFavouritePhoneNumbers;
        return this;
    }

    public Tariffing getTariffing() {
        return tariffing;
    }

    public ParametersBuilder buildTariffing(Tariffing tariffing) {
        this.tariffing = tariffing;
        return this;
    }

    public double getConnectionCost() {
        return connectionCost;
    }

    public ParametersBuilder setConnectionCost(double connectionCost) {
        this.connectionCost = connectionCost;
        return this;
    }
}
