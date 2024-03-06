package exercises;

public class ExerciseStorage {
    private Exercise[] exercises;
    public ExerciseStorage(Exercise[] exercises) {
        this.exercises = exercises;
    }
    public final Exercise[] getExercises()  {
        return exercises;
    }
    public final void setExercises(Exercise[] exercises) {
        this.exercises = exercises;
    }
    public final void addExercise(Exercise exercise) {
        Exercise[] newExercises = new Exercise[exercises.length + 1];
        for (int i = 0; i < exercises.length; i++) {
            newExercises[i] = exercises[i];
        }
        newExercises[exercises.length] = exercise;
        exercises = newExercises;
    }
    public final void removeExercise(Exercise exercise) {
        Exercise[] newExercises = new Exercise[exercises.length - 1];
        int j = 0;
        for (int i = 0; i < exercises.length; i++) {
            if (exercises[i] != exercise) {
                newExercises[j] = exercises[i];
                j++;
            }
        }
        exercises = newExercises;
    }
    public final Exercise getExerciseByName(String name) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name)) {
                return exercise;
            }
        }
        return null;
    }
}
