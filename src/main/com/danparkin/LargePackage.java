package com.danparkin;

import java.math.BigDecimal;

public class LargePackage implements SizedPackage {
    private final int depth;
    private final int height;
    private final int weight;
    private final int width;

    public LargePackage(int depth, int height, int weight, int width) {
        this.depth = depth;
        this.height = height;
        this.weight = weight;
        this.width = width;
    }

    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(Math.max(weight, height * width * depth / 1000) * 6);
    }
}
