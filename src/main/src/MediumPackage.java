package src;

import java.math.BigDecimal;

class MediumPackage {
    private final int weight;

    MediumPackage(int weight) {

        this.weight = weight;
    }

    BigDecimal postageInBaseCurrency() {
        return new BigDecimal(weight * 4);
    }
}