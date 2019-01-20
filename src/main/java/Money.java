import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final Currency currency;
    private final BigDecimal amount;

    Money(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public java.lang.String toString() {
        return String.format("Currency: %s, Amount: %f", currency, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var money = (Money) o;
        return currency == money.currency &&
                Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(currency, amount);
    }
}
