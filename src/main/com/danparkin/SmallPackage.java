package com.danparkin;

import java.math.BigDecimal;

public class SmallPackage extends SizedPackage {
    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(120);
    }
}
