package src;

import java.math.BigDecimal;

public class Package {
    private SizedPackage sizedPackage;

    public Package(int weight, int height, int width, int depth) {
        sizedPackage = SizedPackage.withDimensions(depth, height, weight, width);
    }

    public BigDecimal postageInBaseCurrency() {
        return sizedPackage.postageInBaseCurrency();
    }
}
