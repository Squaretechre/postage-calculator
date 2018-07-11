package com.danparkin;

import java.math.BigDecimal;

public class Package {
    private final SizedPackage sizedPackage;

    public Package(SizedPackage sizedPackage) {
        this.sizedPackage = sizedPackage;
    }

    public BigDecimal PostageInBaseCurrency()
    {
        return sizedPackage.postageInBaseCurrency();
    }
}
