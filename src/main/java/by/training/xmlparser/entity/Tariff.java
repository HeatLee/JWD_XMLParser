package by.training.xmlparser.entity;

import by.training.xmlparser.builder.AbstractTariffBuilder;

import java.util.Objects;

public class Tariff {
    private String name;
    private String operatorName;
    private double payroll;
    private CallPrice callPrice;
    private double SMSPrice;
    private Parameters parameters;

    public Tariff() {

    }

    public Tariff(AbstractTariffBuilder builder) {
        this.name = builder.getName();
        this.operatorName = builder.getOperatorName();
        this.payroll = builder.getPayroll();
        this.callPrice = builder.getCallPrice();
        this.SMSPrice = builder.getSmsPrice();
        this.parameters = builder.getParameters();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public CallPrice getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(CallPrice callPrice) {
        this.callPrice = callPrice;
    }

    public double getSMSPrice() {
        return SMSPrice;
    }

    public void setSMSPrice(double SMSPrice) {
        this.SMSPrice = SMSPrice;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return Double.compare(tariff.payroll, payroll) == 0 &&
                Double.compare(tariff.SMSPrice, SMSPrice) == 0 &&
                Objects.equals(name, tariff.name) &&
                Objects.equals(operatorName, tariff.operatorName) &&
                Objects.equals(callPrice, tariff.callPrice) &&
                Objects.equals(parameters, tariff.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, operatorName, payroll, callPrice, SMSPrice, parameters);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrice=" + callPrice +
                ", SMSPrice=" + SMSPrice +
                ", parameters=" + parameters +
                '}';
    }
}
