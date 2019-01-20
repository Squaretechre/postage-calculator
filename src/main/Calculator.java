import src.Package;

import java.math.BigDecimal;

class Calculator {
    Money calculate(int weight, int height, int width, int depth, Currency currency) {
        BigDecimal postageInBaseCurrency = postageInBaseCurrency(new Package(weight, height, width, depth));
        return convertCurrency(postageInBaseCurrency, currency);
    }

    private BigDecimal postageInBaseCurrency(Package aPackage) {
        if (aPackage.getWeight() <= 60 && aPackage.getHeight() <= 229 && aPackage.getWidth() <= 162 && aPackage.getDepth() <= 25) {
            return new BigDecimal(120);
        }
        if (aPackage.getWeight() <= 500 && aPackage.getHeight() <= 324 && aPackage.getWidth() <= 229 && aPackage.getDepth() <= 100) {
            return new BigDecimal(aPackage.getWeight() * 4);
        }
        return new BigDecimal(Math.max(aPackage.getWeight(), aPackage.getHeight() * aPackage.getWidth() * aPackage.getDepth() / 1000) * 6);
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
