package src;

import java.math.BigDecimal;

public class MediumPackage {
    static BigDecimal mediumPackagePostageInBaseCurrency(int weight) {
        return new BigDecimal(weight * 4);
    }
}