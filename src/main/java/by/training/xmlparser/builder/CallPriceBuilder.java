package by.training.xmlparser.builder;

public class CallPriceBuilder {
    private double priceWithinNetwork;
    private double priceInOtherNetworks;
    private double priceForStandardPhoneNumbers;

    public double getPriceWithinNetwork() {
        return priceWithinNetwork;
    }

    public CallPriceBuilder buildPriceWithinNetwork(double priceWithinNetwork) {
        this.priceWithinNetwork = priceWithinNetwork;
        return this;
    }

    public double getPriceInOtherNetworks() {
        return priceInOtherNetworks;
    }

    public CallPriceBuilder buildPriceInOtherNetworks(double priceInOtherNetworks) {
        this.priceInOtherNetworks = priceInOtherNetworks;
        return this;
    }

    public double getPriceForStandardPhoneNumbers() {
        return priceForStandardPhoneNumbers;
    }

    public CallPriceBuilder buildPriceForStandardPhoneNumbers(double priceForStandardPhoneNumbers) {
        this.priceForStandardPhoneNumbers = priceForStandardPhoneNumbers;
        return this;
    }
}
