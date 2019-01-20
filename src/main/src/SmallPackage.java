package src;

import java.math.BigDecimal;

public class SmallPackage {
    public SmallPackage() {
    }

    BigDecimal smallPackagePostageInBaseCurrency() {
        return new BigDecimal(120);
    }
}