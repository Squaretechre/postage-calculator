package src;

import java.math.BigDecimal;

class SmallPackage {
    SmallPackage() {
    }

    BigDecimal smallPackagePostageInBaseCurrency() {
        return new BigDecimal(120);
    }
}