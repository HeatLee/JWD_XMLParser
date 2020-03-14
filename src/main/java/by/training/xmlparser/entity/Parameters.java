package by.training.xmlparser.entity;

import by.training.xmlparser.builder.ParametersBuilder;

import java.util.Objects;

public class Parameters {
    private boolean containsFavouritePhoneNumbers;
    private Tariffing tariffing;
    private double connectionCost;

    public Parameters() {
    }

    public Parameters(ParametersBuilder builder) {
        this.containsFavouritePhoneNumbers = builder.isContainsFavouritePhoneNumbers();
        this.tariffing = builder.getTariffing();
        this.connectionCost = builder.getConnectionCost();
    }

    public boolean isContainsFavouritePhoneNumbers() {
        return containsFavouritePhoneNumbers;
    }

    public void setContainsFavouritePhoneNumbers(boolean containsFavouritePhoneNumbers) {
        this.containsFavouritePhoneNumbers = containsFavouritePhoneNumbers;
    }

    public Tariffing getTariffing() {
        return tariffing;
    }

    public void setTariffing(Tariffing tariffing) {
        this.tariffing = tariffing;
    }

    public double getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(double connectionCost) {
        this.connectionCost = connectionCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return containsFavouritePhoneNumbers == that.containsFavouritePhoneNumbers &&
                Double.compare(that.connectionCost, connectionCost) == 0 &&
                tariffing == that.tariffing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(containsFavouritePhoneNumbers, tariffing, connectionCost);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "containsFavouritePhoneNumbers=" + containsFavouritePhoneNumbers +
                ", tariffing=" + tariffing +
                ", price=" + connectionCost +
                '}';
    }
}
