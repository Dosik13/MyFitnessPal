package app;

import commanders.CommandExercises;
import commands.Command;
import exercises.Exercise;
import exercises.Routine;
import exercises.RoutineEngine;
import exercises.RoutineLog;
import storage.Storage;
import menu.CommandMenu;

import menu.ExercisesMenuCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage<Routine> routineStorage = new Storage<>(new ArrayList<>());
        Storage<Exercise> exerciseStorage = new Storage<>(new ArrayList<>());
        Storage<RoutineLog> logStorage = new Storage<>(new ArrayList<>());
        RoutineEngine routineEngine = new RoutineEngine(routineStorage, exerciseStorage, logStorage);
        CommandExercises commandExercises = new CommandExercises(routineEngine);
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("exercises", new ExercisesMenuCommand(commandExercises));
        new CommandMenu(scanner, commandMap).start();
    }
}
