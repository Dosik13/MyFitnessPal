package profile;

public record Anthropometry(int height, int weight) {

    public Anthropometry {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
    }
}
