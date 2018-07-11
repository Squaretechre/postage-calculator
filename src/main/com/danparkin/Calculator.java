package com.danparkin;

import java.math.BigDecimal;

public class Calculator {
    public Money Calculate(int weight, int height, int width, int depth, Currency currency)
    {
        BigDecimal postageInBaseCurrency = new Package(weight, height, width, depth).PostageInBaseCurrency();
        return ConvertCurrency(postageInBaseCurrency, currency);
    }

    private Money ConvertCurrency(BigDecimal amountInBaseCurrency, Currency currency)
    {
        if (currency == Currency.Gbp)
            return new Money(Currency.Gbp, amountInBaseCurrency);
        if(currency == Currency.Eur) {
            BigDecimal commission = new BigDecimal(200);
            BigDecimal basePrice = amountInBaseCurrency.add(commission);
            BigDecimal rate = new BigDecimal(1.25);
            return new Money(Currency.Eur, basePrice.multiply(rate));
        }
        if(currency == Currency.Chf) {
            BigDecimal commission = new BigDecimal(200);
            BigDecimal basePrice = amountInBaseCurrency.add(commission);
            BigDecimal rate = new BigDecimal(1.36);
            return new Money(Currency.Chf, basePrice.multiply(rate));
        }
        throw new UnsupportedOperationException("Currency not supported");
    }
}
