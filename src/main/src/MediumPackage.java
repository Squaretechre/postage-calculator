package src;

import java.math.BigDecimal;

class MediumPackage implements SizedPackage {
    private final int weight;

    MediumPackage(int weight) {

        this.weight = weight;
    }

    @Override
    public BigDecimal postageInBaseCurrency() {
        return new BigDecimal(weight * 4);
    }
}