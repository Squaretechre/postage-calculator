package com.danparkin;

import java.math.BigDecimal;

public class Calculator {
    public Money Calculate(int weight, int height, int width, int depth, Currency currency)
    {
        var amountInBaseCurrency = PostalPackage.withDimensions(depth, height, weight, width).postageInBaseCurrency();
        return ConvertCurrency(amountInBaseCurrency, currency);
    }

    private Money ConvertCurrency(BigDecimal amountInBaseCurrency, Currency currency)
    {
        if (currency == Currency.Gbp)
            return new Money(Currency.Gbp, amountInBaseCurrency);
        if(currency == Currency.Eur) {
            var commission = new BigDecimal(200);
            var basePrice = amountInBaseCurrency.add(commission);
            var rate = new BigDecimal(1.25);
            return new Money(Currency.Eur, basePrice.multiply(rate));
        }
        if(currency == Currency.Chf) {
            var commission = new BigDecimal(200);
            var basePrice = amountInBaseCurrency.add(commission);
            var rate = new BigDecimal(1.36);
            return new Money(Currency.Chf, basePrice.multiply(rate));
        }
        throw new UnsupportedOperationException("Currency not supported");
    }
}
