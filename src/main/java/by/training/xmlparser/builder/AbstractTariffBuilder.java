package by.training.xmlparser.builder;

import by.training.xmlparser.entity.CallPrice;
import by.training.xmlparser.entity.Parameters;
import by.training.xmlparser.entity.Tariff;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffBuilder {
    protected Set<Tariff> tariffs;
    private String name;
    private String OperatorName;
    private double payroll;
    private CallPrice callPrice;
    private double smsPrice;
    private Parameters parameters;


    public AbstractTariffBuilder() {
        tariffs = new HashSet<>();
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public abstract void buildTariffs(InputStream file);

    public String getName() {
        return name;
    }

    public AbstractTariffBuilder buildName(String name) {
        this.name = name;
        return this;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public AbstractTariffBuilder buildOperatorName(String operatorName) {
        OperatorName = operatorName;
        return this;
    }

    public double getPayroll() {
        return payroll;
    }

    public AbstractTariffBuilder buildPayroll(double payroll) {
        this.payroll = payroll;
        return this;
    }

    public CallPrice getCallPrice() {
        return callPrice;
    }

    public AbstractTariffBuilder buildCallPrice(CallPrice callPrice) {
        this.callPrice = callPrice;
        return this;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public AbstractTariffBuilder buildSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
        return this;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public AbstractTariffBuilder buildParameters(Parameters parameters) {
        this.parameters = parameters;
        return this;
    }
}
