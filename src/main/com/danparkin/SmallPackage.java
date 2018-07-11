package com.danparkin;

import java.math.BigDecimal;

public class SmallPackage extends PostalPackage {
    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(120);
    }
}
