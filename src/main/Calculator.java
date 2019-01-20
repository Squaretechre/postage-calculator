import src.Package;

import java.math.BigDecimal;

class Calculator {
    Money calculate(int weight, int height, int width, int depth, Currency currency) {
        BigDecimal postageInBaseCurrency = Package.withDimensions(depth, height, weight, width).postageInBaseCurrency();
        return convertCurrency(postageInBaseCurrency, currency);
    }

    private Money convertCurrency(BigDecimal amountInBaseCurrency, Currency currency) {
        if (currency == Currency.Gbp)
            return new Money(Currency.Gbp, amountInBaseCurrency);
        if (currency == Currency.Eur) {
            BigDecimal commission = new BigDecimal(200);
            BigDecimal basePrice = amountInBaseCurrency.add(commission);
            BigDecimal rate = new BigDecimal(1.25);
            return new Money(Currency.Eur, basePrice.multiply(rate));
        }
        if (currency == Currency.Chf) {
            BigDecimal commission = new BigDecimal(200);
            BigDecimal basePrice = amountInBaseCurrency.add(commission);
            BigDecimal rate = new BigDecimal(1.36);
            return new Money(Currency.Chf, basePrice.multiply(rate));
        }
        throw new UnsupportedOperationException("Currency not supported");
    }
}
