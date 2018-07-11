package com.danparkin;

import java.math.BigDecimal;

public class MediumPackage {
    private final int weight;

    public MediumPackage(int weight) {
        this.weight = weight;
    }

    public BigDecimal mediumPackagePostageInBaseCurrency() {
        return new BigDecimal(weight * 4);
    }
}
