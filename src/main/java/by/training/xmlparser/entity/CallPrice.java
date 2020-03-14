package by.training.xmlparser.entity;

import by.training.xmlparser.builder.CallPriceBuilder;

import java.util.Objects;

public class CallPrice {
    private double withinNetworkPrice;
    private double otherNetworkPrice;
    private double standardPhoneNumbersPrice;

    public CallPrice() {
    }

    public CallPrice(CallPriceBuilder builder) {
        this.withinNetworkPrice = builder.getPriceWithinNetwork();
        this.otherNetworkPrice = builder.getPriceInOtherNetworks();
        this.standardPhoneNumbersPrice = builder.getPriceForStandardPhoneNumbers();
    }

    public double getWithinNetworkPrice() {
        return withinNetworkPrice;
    }

    public void setWithinNetworkPrice(double withinNetworkPrice) {
        this.withinNetworkPrice = withinNetworkPrice;
    }

    public double getOtherNetworkPrice() {
        return otherNetworkPrice;
    }

    public void setOtherNetworkPrice(double otherNetworkPrice) {
        this.otherNetworkPrice = otherNetworkPrice;
    }

    public double getStandardPhoneNumbersPrice() {
        return standardPhoneNumbersPrice;
    }

    public void setStandardPhoneNumbersPrice(double standardPhoneNumbersPrice) {
        this.standardPhoneNumbersPrice = standardPhoneNumbersPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallPrice callPrice = (CallPrice) o;
        return Double.compare(callPrice.withinNetworkPrice, withinNetworkPrice) == 0 &&
                Double.compare(callPrice.otherNetworkPrice, otherNetworkPrice) == 0 &&
                Double.compare(callPrice.standardPhoneNumbersPrice, standardPhoneNumbersPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(withinNetworkPrice, otherNetworkPrice, standardPhoneNumbersPrice);
    }

    @Override
    public String toString() {
        return "CallPrice{" +
                "withinNetworkPrice=" + withinNetworkPrice +
                ", otherNetworkPrice=" + otherNetworkPrice +
                ", standardPhoneNumbersPrice=" + standardPhoneNumbersPrice +
                '}';
    }
}
