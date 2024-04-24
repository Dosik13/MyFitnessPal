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

}
