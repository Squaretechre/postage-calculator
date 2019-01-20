import java.math.BigDecimal;

class Calculator {
    Money Calculate(int weight, int height, int width, int depth, Currency currency)
    {
        var postageInBaseCurrency = PostageInBaseCurrency(weight, height, width, depth);
        return ConvertCurrency(postageInBaseCurrency, currency);
    }

    private BigDecimal PostageInBaseCurrency(int weight, int height, int width, int depth)
    {
        if (weight <= 60 && height <= 229 && width <= 162 && depth <= 25)
        {
            return new BigDecimal(120);
        }
        if (weight <= 500 && height <= 324 && width <= 229 && depth <= 100)
        {
            return new BigDecimal(weight * 4);
        }
        return new BigDecimal(Math.max(weight, height*width*depth/1000)*6);
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
