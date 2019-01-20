package src;

import java.math.BigDecimal;

public abstract class Package {
    public static Package withDimensions(int depth, int height, int weight, int width) {
        if (isSmall(depth, height, weight, width)) {
            return new SmallPackage();
        }
        if (isMedium(depth, height, weight, width)) {
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

    public abstract BigDecimal postageInBaseCurrency();
}
