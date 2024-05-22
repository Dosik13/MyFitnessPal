package exercises;

import java.time.LocalDate;
import java.util.List;

public class RoutineEngine {
    private final Storage<Routine> routineStorage;
    private final Storage<Exercise> exerciseStorage;
    private final Storage<RoutineLog> routineLogStorage;

    public RoutineEngine(Storage<Routine> routineStorage, Storage<Exercise> exerciseStorage,
                         Storage<RoutineLog> routineLogStorage) {
        this.routineStorage = routineStorage;
        this.exerciseStorage = exerciseStorage;
        this.routineLogStorage = routineLogStorage;
    }

    public final Routine addRoutine(String name, String instructions) {
        return new Routine(name, instructions);
    }

    public final void addExercisesToRoutine(Routine routine, List<String> inputs) {
        for (int i = 0; i < inputs.size(); i += 4) {
            String exerciseName = inputs.get(i);
            Exercise exercise = exerciseStorage.getEntityByName(exerciseName);
            if (exercise == null) {
                System.out.println(Messages.EXERCISE_NOT_FOUND);
                continue;
            }

            int sets = Integer.parseInt(inputs.get(i + 1));
            int reps = Integer.parseInt(inputs.get(i + 2));
            Integer kg = null;
            String kgInput = inputs.get(i + 3);
            if (!kgInput.isEmpty()) {
                kg = Integer.parseInt(kgInput);
            }
            exercise.setKg(kg);

            RoutineElement element = new RoutineElement(exercise, reps, sets);
            routine.addElement(element);
        }
    }

    public final void createRoutine(String name, String instructions, List<String> inputs) {
        Routine routine = addRoutine(name, instructions);
        addExercisesToRoutine(routine, inputs);
        System.out.println(Messages.ROUTINE_CREATED);
        routineStorage.addEntity(routine);
    }

    public final void removeRoutineByName(String name) {
        routineStorage.removeEntityByName(name);
    }

    public final List<Routine> getAllRoutines() {
        return routineStorage.getEntities();
    }

    public final void printRoutineList() {
        for (int i = 0; i < getAllRoutines().size(); i++) {
            System.out.println(i + 1 + ". " + getAllRoutines().get(i).getName());
        }
    }

    public final void logRoutine(LocalDate date, String routineName) {
        Routine routine = routineStorage.getEntityByName(routineName);
        if (routine == null) {
            System.out.println("Routine not found: " + routineName);
            return;
        }

        RoutineLog log = new RoutineLog(date, routine);
        routineLogStorage.addEntity(log);
        System.out.println("Routine logged: " + log);
    }

    public final void printRoutineLogs(String routineName) {
        List<RoutineLog> logs = routineLogStorage.getEntities();
        System.out.println("Log dates for routine: " + routineName);
        for (RoutineLog log : logs) {
            if (log.getRoutine().getName().equalsIgnoreCase(routineName)) {
                System.out.println(log.getDate());
            }
        }
    }
}
