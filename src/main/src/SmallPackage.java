package src;

import java.math.BigDecimal;

class SmallPackage extends SizedPackage {
    SmallPackage() {
    }

    @Override
    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(120);
    }
}