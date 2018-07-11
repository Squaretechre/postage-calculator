package com.danparkin;

import java.math.BigDecimal;

public class SmallPackage implements SizedPackage {
    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(120);
    }
}
