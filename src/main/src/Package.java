package src;

import java.math.BigDecimal;

public class Package {
    private final int weight;
    private final int height;
    private final int width;
    private final int depth;

    public Package(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public BigDecimal postageInBaseCurrency() {
        if (isSmall()) {
            return new SmallPackage().smallPackagePostageInBaseCurrency();
        }
        if (isMedium()) {
            return new MediumPackage(weight).mediumPackagePostageInBaseCurrency();
        }
        return new LargePackage(depth, height, weight, width).largePackagePostageInBaseCurrency();
    }

    private boolean isMedium() {
        return weight <= 500 && height <= 324 && width <= 229 && depth <= 100;
    }

    private boolean isSmall() {
        return weight <= 60 && height <= 229 && width <= 162 && depth <= 25;
    }
}
