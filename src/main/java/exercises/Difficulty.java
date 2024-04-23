package exercises;

public enum Difficulty {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    INTERMEDIATE("intermediate"),
    EXTREME("extreme");

    private final String value;

    Difficulty(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
