package exercises;

import java.util.List;

public class RoutineStorage {
    private final List<Routine> routines;

    public RoutineStorage(List<Routine> routines) {
        this.routines = routines;
    }

    public final void addRoutine(Routine routine) {
        routines.add(routine);
    }

    public final List<Routine> getAllRoutines() {
        return routines;
    }

    public final void removeRoutineByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(Messages.ROUTINE_NAME_CANNOT_BE_NULL);
        }

        for (Routine routine : routines) {
            if (routine.getName().equals(name)) {
                routines.remove(routine);
                return;
            }
        }
    }

    public final Routine getRoutineByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(Messages.ROUTINE_NAME_CANNOT_BE_NULL);
        }

        for (Routine routine : routines) {
            if (routine.getName().equals(name)) {
                return routine;
            }
        }

        return null;
    }

}
