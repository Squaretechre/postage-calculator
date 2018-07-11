package com.danparkin;

import java.math.BigDecimal;

public class Package {
    private final SizedPackage sizedPackage;

    public Package(int weight, int height, int width, int depth) {
        sizedPackage = SizedPackage.createSizedPackage(depth, height, weight, width);
    }

    public BigDecimal PostageInBaseCurrency()
    {
        return sizedPackage.postageInBaseCurrency();
    }

}
