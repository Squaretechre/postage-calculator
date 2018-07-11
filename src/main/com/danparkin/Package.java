package com.danparkin;

import java.math.BigDecimal;

public class Package {
    private final int weight;
    private final int height;
    private final int width;
    private final int depth;
    private final SizedPackage sizedPackage;

    public Package(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        sizedPackage = createSizedPackage(depth, height, weight, width);
    }

    public BigDecimal PostageInBaseCurrency()
    {
        return sizedPackage.postageInBaseCurrency();
    }

    private static SizedPackage createSizedPackage(int depth, int height, int weight, int width) {
        if (isSmall(depth, height, weight, width))
        {
            return new SmallPackage();
        }
        if (isMedium(depth, height, weight, width))
        {
            return new MediumPackage(weight);
        }
        return new LargePackage(depth, height, weight, width);
    }

    private static boolean isMedium(int depth, int height, int weight, int width) {
        return weight <= 500 && height <= 324 && width <= 229 && depth <= 100;
    }

    private static boolean isSmall(int depth, int height, int weight, int width) {
        return weight <= 60 && height <= 229 && width <= 162 && depth <= 25;
    }

}
