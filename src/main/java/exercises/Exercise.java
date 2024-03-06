package exercises;

public class Exercise {
    private String name;
    private String description;
    private String[] targetMuscles;
    private int sets;
    private int reps;
    private String[] equipment;
    private String difficulty;

    public Exercise(String name, String description, String[] targetMuscles, String[] equipment, String difficulty) {
        this.name = name;
        this.description = description;
        this.targetMuscles = targetMuscles;
        this.equipment = equipment;
        this.difficulty = difficulty;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String[] getTargetMuscles() {
        return targetMuscles;
    }
    public int getSets() {
        return sets;
    }
    public int getReps() {
        return reps;
    }
    public String[] getEquipment() {
        return equipment;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTargetMuscles(String[] targetMuscles) {
        this.targetMuscles = targetMuscles;
    }
    public void setSets(int sets) {
        if(sets < 1) {
            throw new IllegalArgumentException("Sets must be greater than 0");
        }
        if(sets > 100){
            throw new IllegalArgumentException("Sets must be less than 100");
        }
        this.sets = sets;
    }
    public void setReps(int reps) {
        if(reps < 1) {
            throw new IllegalArgumentException("Reps must be greater than 0");
        }
        if(reps > 1000){
            throw new IllegalArgumentException("Reps must be less than 1000");
        }
        this.reps = reps;
    }
    public void setEquipment(String[] equipment) {
        this.equipment = equipment;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
