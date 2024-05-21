package app;

import commanders.CommandExercises;
import exercises.RoutineEngine;
import menu.CommandMenu;
import exercises.ExerciseStorage;
import exercises.RoutineLogStorage;
import exercises.RoutineStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class APP implements Application {
    private final CommandMenu menu;

    public APP(CommandMenu menu) {
        this.menu = menu;
    }

    public final void run() {
        menu.start();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoutineStorage routineStorage = new RoutineStorage(new ArrayList<>());
        ExerciseStorage exerciseStorage = new ExerciseStorage(new ArrayList<>());
        RoutineLogStorage logStorage = new RoutineLogStorage(new ArrayList<>());
        RoutineEngine routineEngine = new RoutineEngine(routineStorage, exerciseStorage, logStorage);
        CommandExercises commandExercises = new CommandExercises(routineEngine);
        APP app = new APP(new CommandMenu(scanner, commandExercises));
        app.run();
    }
}
