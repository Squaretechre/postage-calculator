package src;

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
}
