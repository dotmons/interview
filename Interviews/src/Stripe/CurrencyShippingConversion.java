package Stripe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CurrencyShippingConversion {

    private String frmCurrency;
    private String toCurrency;
    private String shippingAgent;
    private int shippingAmount;

    List<CurrencyShippingConversion> shippingConversionList = new ArrayList<>();
    /*
    Technical Phone Screen:
    The technical phone screen was scheduled after my initial screening with HR. The interviewer explained that the problem would be divided into four parts, and I would be evaluated based on completion and code quality.

    Part 1: Parse a string in the format "USD:CAD:DHL:5,USD:GBP:FEDX:10", representing currency conversion rates from a source to a target currency and the associated shipping method. Write a method to convert a given amount from one currency to another. Only direct conversions are allowed.

    Part 2: Write a method that returns the cost and shipping methods involved, allowing at most one hop in the conversion from one currency to another.

    Part 3: Write a method that returns the minimum cost and involved shipping methods, allowing at most one hop for the conversion.
     */
    public CurrencyShippingConversion() {
        loadShippingList();
        CurrencyShippingConversion currencyShippingConversion = new CurrencyShippingConversion("CAD", "USD", "", -1);
        System.out.println("currencyConversion : " + currencyConversion(currencyShippingConversion));
    }
    public CurrencyShippingConversion(String frmCurrency, String toCurrency, String shippingAgent, int shippingAmount) {
        this.frmCurrency = frmCurrency;
        this.toCurrency = toCurrency;
        this.shippingAgent = shippingAgent;
        this.shippingAmount = shippingAmount;
    }

    public int currencyConversion(CurrencyShippingConversion currencyShippingConversion) {

        List<CurrencyShippingConversion> currencyMapList = new ArrayList<>();

        for (CurrencyShippingConversion currencyConversion : shippingConversionList) {
            if (currencyShippingConversion.frmCurrency.equals(currencyConversion.frmCurrency)
                    && currencyShippingConversion.toCurrency.equals(currencyConversion.toCurrency)
                    && currencyShippingConversion.shippingAgent.equals(currencyConversion.shippingAgent)) {
                return currencyConversion.shippingAmount;
            }
            else if (currencyShippingConversion.frmCurrency.equals(currencyConversion.frmCurrency)){
                currencyMapList.add(currencyConversion);
            }
        }

        // To check for one more hop in the loop
        if (currencyMapList.isEmpty()) {
            return -1;
        }

        // Sort the currencyMapList so it can contain the least pricing first
        currencyMapList.sort(Comparator.comparing( c -> c.shippingAmount));


        for (CurrencyShippingConversion currencyConversion : currencyMapList) {
            for (CurrencyShippingConversion currencyShippingConversion1 : shippingConversionList){
                if (currencyConversion.toCurrency.equals(currencyShippingConversion1.frmCurrency) && currencyShippingConversion1.toCurrency.equals(currencyShippingConversion.toCurrency)){
                    return currencyShippingConversion1.shippingAmount + currencyConversion.shippingAmount;
                }
            }
        }

        return -1;
    }

    public void loadShippingList(){
        shippingConversionList.add(new CurrencyShippingConversion(CurrencyType.USD.name(), CurrencyType.CAD.name(), ShippingAgent.DHL.name(), 5));
        shippingConversionList.add(new CurrencyShippingConversion(CurrencyType.USD.name(), CurrencyType.GBP.name(), ShippingAgent.FEDX.name(), 10));
        shippingConversionList.add(new CurrencyShippingConversion(CurrencyType.CAD.name(), CurrencyType.GBP.name(), ShippingAgent.UPS.name(), 7));
        shippingConversionList.add(new CurrencyShippingConversion(CurrencyType.CAD.name(), CurrencyType.GBP.name(), ShippingAgent.DHL.name(), 6));
        shippingConversionList.add(new CurrencyShippingConversion(CurrencyType.GBP.name(), CurrencyType.USD.name(), ShippingAgent.DHL.name(), 4));
        shippingConversionList.add(new CurrencyShippingConversion(CurrencyType.YEN.name(), CurrencyType.USD.name(), ShippingAgent.DHL.name(), 19));
        //CAD -> GBP -> USD : 7 + 4 = 11;
    }

    enum CurrencyType {
        USD, CAD, GBP, YEN
    }

    enum ShippingAgent {
        DHL, FEDX, UPS
    }


    public static void main(String[] args) {
        new CurrencyShippingConversion();
    }
}
