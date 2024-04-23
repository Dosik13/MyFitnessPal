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
            throw new IllegalArgumentException(Messages.SETS_MUST_BE_GREATER_THAN_0);
        }
        if (sets > 100) {
            throw new IllegalArgumentException(Messages.SETS_MUST_BE_LESS_THAN_100);
        }
        this.sets = sets;
    }

    public final void setReps(int reps) {
        if (reps < 1) {
            throw new IllegalArgumentException(Messages.REPS_MUST_BE_GREATER_THAN_0);
        }
        if (reps > 1000) {
            throw new IllegalArgumentException(Messages.REPS_MUST_BE_LESS_THAN_1000);
        }
        this.reps = reps;
    }
}
