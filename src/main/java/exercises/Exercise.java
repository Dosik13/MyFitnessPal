package exercises;


import java.util.List;

public class Exercise implements Nameable {
    private String name;
    private String description;
    private List<Muscle> targetMuscles;
    private List<String> equipment;
    private Difficulty difficulty;
    private Integer kg;

    public Exercise(String name, String description, List<Muscle> targetMuscles,
                    List<String> equipment, Difficulty difficulty, Integer kg) {
        this.name = name;
        this.description = description;
        this.targetMuscles = targetMuscles;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.kg = kg;
    }

    public Exercise(String name, String description, List<Muscle> targetMuscles,
                    List<String> equipment, Difficulty difficulty) {
        this(name, description, targetMuscles, equipment, difficulty, null);
    }

    public final String getName() {
        return name;
    }

    public final Integer getKg() {
        return kg;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setKg(Integer kg) {
        this.kg = kg;
    }

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

}
