package exercises;

import java.util.List;

public class RoutineStorage {
    private List<Routine> routines;
    private RoutineEngine engine;

    public RoutineStorage(List<Routine> routines) {
        this.routines = routines;
    }

    public final void addRoutine() {
        Routine routine = engine.createRoutine();
        routines.add(routine);
    }

    public final boolean removeRoutineByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(Messages.ROUTINE_NAME_CANNOT_BE_NULL);
        }

        for (Routine routine : routines) {
            if (routine.getName().equals(name)) {
                routines.remove(routine);
                return true;
            }
        }

        return false;
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

    public final void printRoutineList() {
        for (Routine routine : routines) {
            System.out.println(routine.getName());
        }
    }
}

