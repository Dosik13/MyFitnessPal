package commands.water;

public enum CupVolume {
    SMALL(100),
    MEDIUM(250),
    LARGE(500);

    private final int size;
    private static final String UNIT = "ml";

    CupVolume(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static String getUnit() {
        return UNIT;
    }

}

