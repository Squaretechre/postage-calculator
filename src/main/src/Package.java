package src;

import java.math.BigDecimal;

public class Package {
    private SizedPackage sizedPackage;

    public Package(SizedPackage sizedPackage1) {
       sizedPackage = sizedPackage1;
    }

    public BigDecimal postageInBaseCurrency() {
        return sizedPackage.postageInBaseCurrency();
    }
}
