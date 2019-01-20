package src;

import java.math.BigDecimal;

class SmallPackage extends Package {
    SmallPackage() {
    }

    @Override
    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(120);
    }
}