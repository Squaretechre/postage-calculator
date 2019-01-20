package src;

public class LargePackage {
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

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getWidth() {
        return width;
    }
}
