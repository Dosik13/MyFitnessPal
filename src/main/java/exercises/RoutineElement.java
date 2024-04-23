package exercises;

public class RoutineElement {
    private Exercise exercise;
    private int reps;
    private int sets;

    public RoutineElement(Exercise exercise, int reps, int sets) {
        this.exercise = exercise;
        this.reps = reps;
        this.sets = sets;
    }

    public final Exercise getExercise() {
        return exercise;
    }

    public final int getReps() {
        return reps;
    }

    public final int getSets() {
        return sets;
    }

    public final void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public final void setSets(int sets) {
        if (sets < 1) {
            throw new IllegalArgumentException("Sets must be greater than 0");
        }
        if (sets > 100) {
            throw new IllegalArgumentException("Sets must be less than 100");
        }
        this.sets = sets;
    }

    public final void setReps(int reps) {
        if (reps < 1) {
            throw new IllegalArgumentException("Reps must be greater than 0");
        }
        if (reps > 1000) {
            throw new IllegalArgumentException("Reps must be less than 1000");
        }
        this.reps = reps;
    }
}
