package src;

import java.math.BigDecimal;

public class Package {
    private final int weight;
    private final int height;
    private final int width;
    private final int depth;

    public Package(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public BigDecimal postageInBaseCurrency() {
        if (getWeight() <= 60 && getHeight() <= 229 && getWidth() <= 162 && getDepth() <= 25) {
            return new BigDecimal(120);
        }
        if (getWeight() <= 500 && getHeight() <= 324 && getWidth() <= 229 && getDepth() <= 100) {
            return new BigDecimal(getWeight() * 4);
        }
        return new BigDecimal(Math.max(getWeight(), getHeight() * getWidth() * getDepth() / 1000) * 6);
    }
}
