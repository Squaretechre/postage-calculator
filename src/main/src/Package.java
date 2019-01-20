package src;

import java.math.BigDecimal;

public class Package {
    private final int weight;
    private final int height;
    private final int width;
    private final int depth;
    private final SmallPackage smallPackage = new SmallPackage();

    public Package(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public BigDecimal postageInBaseCurrency() {
        if (isSmall()) {
            return smallPackage.smallPackagePostageInBaseCurrency();
        }
        if (isMedium()) {
            return mediumPackagePostageInBaseCurrency(weight);
        }
        return largePackagePostageInBaseCurrency();
    }

    private BigDecimal largePackagePostageInBaseCurrency() {
        return new BigDecimal(Math.max(weight, height * width * depth / 1000) * 6);
    }

    private static BigDecimal mediumPackagePostageInBaseCurrency(int weight) {
        return new BigDecimal(weight * 4);
    }

    private boolean isMedium() {
        return weight <= 500 && height <= 324 && width <= 229 && depth <= 100;
    }

    private boolean isSmall() {
        return weight <= 60 && height <= 229 && width <= 162 && depth <= 25;
    }
}
