package exercises;

import java.time.LocalDate;
import java.util.List;

public class RoutineEngine {
    private final RoutineStorage routineStorage;
    private final ExerciseStorage exerciseStorage;
    private final RoutineLogStorage routineLogStorage;

    public RoutineEngine(RoutineStorage routineStorage, ExerciseStorage exerciseStorage,
                         RoutineLogStorage routineLogStorage) {
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
            Exercise exercise = exerciseStorage.getExerciseByName(exerciseName);
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
        routineStorage.addRoutine(routine);
    }

    public final void removeRoutineByName(String name) {
        routineStorage.removeRoutineByName(name);
    }

    public final List<Routine> getAllRoutines() {
        return routineStorage.getAllRoutines();
    }

    public final void printRoutineList() {
        for (int i = 0; i < getAllRoutines().size(); i++) {
            System.out.println(i + 1 + ". " + getAllRoutines().get(i).getName());
        }
    }

    public final void logRoutine(LocalDate date, String routineName) {
        Routine routine = routineStorage.getRoutineByName(routineName);
        if (routine == null) {
            System.out.println("Routine not found: " + routineName);
            return;
        }

        RoutineLog log = new RoutineLog(date, routine);
        routineLogStorage.addLog(log);
        System.out.println("Routine logged: " + log);
    }

    public final void printRoutineLogs(String routineName) {
        List<RoutineLog> logs = routineLogStorage.getLogs();
        System.out.println("Log dates for routine: " + routineName);
        for (RoutineLog log : logs) {
            if (log.getRoutine().getName().equalsIgnoreCase(routineName)) {
                System.out.println(log.getDate());
            }
        }
    }
}
