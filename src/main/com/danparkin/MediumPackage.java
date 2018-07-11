package com.danparkin;

import java.math.BigDecimal;

public class MediumPackage extends SizedPackage {
    private final int weight;

    public MediumPackage(int weight) {
        this.weight = weight;
    }

    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(weight * 4);
    }
}
