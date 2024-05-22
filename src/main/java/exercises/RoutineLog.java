package exercises;

import java.time.LocalDate;

public class RoutineLog implements Nameable {
    private LocalDate date;
    private Routine routine;

    public RoutineLog(LocalDate date, Routine routine) {
        this.date = date;
        this.routine = routine;
    }

    public final LocalDate getDate() {
        return date;
    }

    public final Routine getRoutine() {
        return routine;
    }

    public final String toString() {
        return "Date: " + date + ", Routine: " + routine.getName();
    }

    @Override
    public final String getName() {
        return "RoutineLog" + date + ", " + routine.getName();
    }
}
