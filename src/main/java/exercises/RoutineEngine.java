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
        System.out.println("Enter routine name:");
        String name = scanner.nextLine();

        System.out.println("Enter routine instructions:");
        String instructions = scanner.nextLine();

        return new Routine(name, instructions);
    }

    public final void addExercisesToRoutine(Routine routine) {
        while (true) {
            System.out.println("Enter the name of the exercise (or 'quit' to finish):");
            String exerciseName = scanner.nextLine();

            if ("quit".equalsIgnoreCase(exerciseName)) {
                break;
            }

            Exercise exercise = exerciseStorage.getExerciseByName(exerciseName);
            if (exercise == null) {
                System.out.println("Exercise not found. Please try again.");
                continue;
            }

            System.out.println("Enter number of sets: ");
            int sets = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter number of reps: ");
            int reps = Integer.parseInt(scanner.nextLine());

            Integer kg = null;
            if (exercise.getKg() != null) {
                System.out.println("Enter weight in kg (leave blank if not applicable): ");
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
        System.out.println("Routine created successfully.");
        return routine;
    }
}
