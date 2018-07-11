package com.danparkin;

import java.math.BigDecimal;

public class MediumPackage {
    private final int weight;

    public MediumPackage(int weight) {
        this.weight = weight;
    }

    public BigDecimal mediumPackagePostageInBaseCurrency() {
        return new BigDecimal(getWeight() * 4);
    }

    public int getWeight() {
        return weight;
    }
}
