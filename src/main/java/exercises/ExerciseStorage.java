package exercises;

public class ExerciseStorage {
    private Exercise[] exercises;

    public ExerciseStorage(Exercise[] exercises) {
        this.exercises = exercises;
    }

    public Exercise[] getExercises() {
        return exercises;
    }

    public void setExercises(Exercise[] exercises) {
        this.exercises = exercises;
    }

}