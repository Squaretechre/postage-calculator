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
            return new MediumPackage(weight).mediumPackagePostageInBaseCurrency();
        }
        return largePackagePostageInBaseCurrency(depth, height, weight, width);
    }

    private static BigDecimal largePackagePostageInBaseCurrency(int depth, int height, int weight, int width) {
        return new BigDecimal(Math.max(weight, height * width * depth / 1000) * 6);
    }

    private boolean isMedium() {
        return weight <= 500 && height <= 324 && width <= 229 && depth <= 100;
    }

    private boolean isSmall() {
        return weight <= 60 && height <= 229 && width <= 162 && depth <= 25;
    }
}
