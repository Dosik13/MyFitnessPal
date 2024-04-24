package exercises;

import java.util.Scanner;

public class RoutineEngine {
    private final ExerciseStorage exerciseStorage;
    private final Scanner scanner;

    public RoutineEngine(ExerciseStorage exerciseStorage, Scanner scanner) {
        this.exerciseStorage = exerciseStorage;
        this.scanner = scanner;
    }

    public final Routine addRoutine() {
        System.out.println(Messages.ENTER_ROUTINE_NAME);
        String name = scanner.nextLine();

        System.out.println(Messages.ENTER_ROUTINE_INSTRUCTIONS);
        String instructions = scanner.nextLine();

        return new Routine(name, instructions);
    }

    public final void addExercisesToRoutine(Routine routine) {
        while (true) {
            System.out.println(Messages.ENTER_EXERCISE_NAME);
            String exerciseName = scanner.nextLine();

            if (Messages.QUIT.equalsIgnoreCase(exerciseName)) {
                break;
            }

            Exercise exercise = exerciseStorage.getExerciseByName(exerciseName);
            if (exercise == null) {
                System.out.println(Messages.EXERCISE_NOT_FOUND);
                continue;
            }

            System.out.println(Messages.ENTER_NUMBER_OF_SETS);
            int sets = Integer.parseInt(scanner.nextLine());

            System.out.println(Messages.ENTER_NUMBER_OF_REPS);
            int reps = Integer.parseInt(scanner.nextLine());

            Integer kg = null;
            if (exercise.getKg() != null) {
                System.out.println(Messages.ENTER_WEIGHT_IN_KG);
                String kgInput = scanner.nextLine();
                if (!kgInput.isEmpty()) {
                    kg = Integer.parseInt(kgInput);
                }
            }
            exercise.setKg(kg);

            RoutineElement element = new RoutineElement(exercise, reps, sets);
            routine.addElement(element);
        }
    }

    public final Routine createRoutine() {
        Routine routine = addRoutine();
        addExercisesToRoutine(routine);
        System.out.println(Messages.ROUTINE_CREATED);
        return routine;
    }
}
