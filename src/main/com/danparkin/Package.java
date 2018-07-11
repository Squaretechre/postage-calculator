package com.danparkin;

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

    public BigDecimal PostageInBaseCurrency()
    {
        if (isSmall())
        {
            return smallPackagePostageInBaseCurrency();
        }
        if (isMedium())
        {
            return mediumPackagePostageInBaseCurrency();
        }
        return largePackagePostageInBaseCurrency();
    }

    private BigDecimal largePackagePostageInBaseCurrency() {
        return new BigDecimal(Math.max(weight, height * width * depth / 1000) * 6);
    }

    private BigDecimal mediumPackagePostageInBaseCurrency() {
        return new BigDecimal(weight * 4);
    }

    private BigDecimal smallPackagePostageInBaseCurrency() {
        return new BigDecimal(120);
    }

    private boolean isMedium() {
        return weight <= 500 && height <= 324 && width <= 229 && depth <= 100;
    }

    private boolean isSmall() {
        return weight <= 60 && height <= 229 && width <= 162 && depth <= 25;
    }
}
