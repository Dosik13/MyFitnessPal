package exercises;


import java.util.List;

public class Exercise {
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

    public final String getDescription() {
        return description;
    }

    public final List<Muscle> getTargetMuscles() {
        return targetMuscles;
    }

    public final List<String> getEquipment() {
        return equipment;
    }

    public final Difficulty getDifficulty() {
        return difficulty;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final void setTargetMuscles(List<Muscle> targetMuscles) {
        this.targetMuscles = targetMuscles;
    }

    public final void setKg(Integer kg) {
        this.kg = kg;
    }

    public final void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public final void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

}
