package exercises;

import java.util.List;

public class ExerciseStorage {
    private List<Exercise> exercises;

    public ExerciseStorage(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public final List<Exercise> getExercises() {
        return exercises;
    }

    public final void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public final void addExercise(Exercise exercise) {
        if (exercise == null) {
            throw new IllegalArgumentException("Exercise cannot be null");
        }
        exercises.add(exercise);
    }
    public final void removeExercise(Exercise exercise) {
        if (exercise == null) {
            throw new IllegalArgumentException("Exercise cannot be null");
        }
        exercises.remove(exercise);
    }

    public final Exercise getExerciseByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name)) {
                return exercise;
            }
        }
        return null;
    }
}
