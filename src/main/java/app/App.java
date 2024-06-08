package app;

import commanders.CommandExercises;
import commanders.CommandProfile;
import commanders.CommandWater;
import commands.Command;
import exercises.Exercise;
import exercises.Routine;
import exercises.RoutineEngine;
import exercises.RoutineLog;
import menu.ExercisesMenuCommand;
import menu.ProfileMenuCommand;
import menu.WaterMenuCommand;
import storage.Storage;
import menu.CommandMenu;
import profile.Profile;
import profile.registation.RegistrationForm;
import water.WaterStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final int DEFAULT_WATER_DAILY_INTAKE = 2000;
    private final CommandMenu menu;
    private final Profile profile;

    public App(CommandMenu menu, Profile profile) {
        this.menu = menu;
        this.profile = profile;
    }

    public final void run() {
        menu.start();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationForm registrationForm = new RegistrationForm(System.in);
        Profile profile1 = registrationForm.register();
        WaterStorage waterStorage = new WaterStorage(DEFAULT_WATER_DAILY_INTAKE);
        Storage<Routine> routineStorage = new Storage<>(new ArrayList<>());
        Storage<Exercise> exerciseStorage = new Storage<>(new ArrayList<>());
        Storage<RoutineLog> logStorage = new Storage<>(new ArrayList<>());
        RoutineEngine routineEngine = new RoutineEngine(routineStorage, exerciseStorage, logStorage);
        CommandExercises commandExercises = new CommandExercises(routineEngine);
        CommandProfile commandProfile = new CommandProfile(profile1);
        CommandWater commandWater = new CommandWater(waterStorage);
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("exercises", new ExercisesMenuCommand(commandExercises));
        commandMap.put("profile", new ProfileMenuCommand(commandProfile));
        commandMap.put("water", new WaterMenuCommand(commandWater));
        App app = new App(new CommandMenu(scanner, commandMap), profile1);
        app.run();
    }
}
